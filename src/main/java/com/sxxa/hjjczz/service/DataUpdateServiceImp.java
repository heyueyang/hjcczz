package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.dao.*;
import com.sxxa.hjjczz.entity.*;
import com.sxxa.hjjczz.util.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.*;

@Service
@Log4j2
public class DataUpdateServiceImp implements DataUpdateService{
    @Autowired
    private THjjczzTdlyMapper tHjcczzTdlyMapper;
    @Autowired
    private THjjczzSthjzleiMapper mapper ;

    DecimalFormat df = new DecimalFormat("#.00");
    private static final String DATA_PATH = "\\webapps\\hjcczzData\\";

    /**
     * 将前端组装好的环境监测数据，缓存至后端一个文件中
     * @param exResultData
     * @return
     * @throws IOException
     */
    @Override
    public JSONObject hjjczzDataUpdateEchatrs(String exResultData,String year,String fileName) throws IOException {
        String tomcatUrl = System.getProperty("catalina.home");
        String hjjczzDataPath = tomcatUrl + DATA_PATH;
        log.info("DATA_PATH={}" , hjjczzDataPath);
        Path rootLocation = Paths.get(hjjczzDataPath);
        if(Files.notExists(rootLocation)){
            Files.createDirectories(rootLocation);
        }
        Path path = rootLocation.resolve(fileName+""+year);
        File file1 = path.toFile();
        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file1),"UTF-8")
        );
        writer.write(exResultData);
        writer.flush();
        writer.close();
        return null;
    }

    @Override
    public JSONObject hjjczzDataUpdate(String exResultData,String fileName) throws IOException {
        String tomcatUrl = System.getProperty("catalina.home");
        String hjjczzDataPath = tomcatUrl + DATA_PATH;
        log.info("DATA_PATH={}" , hjjczzDataPath);
        Path rootLocation = Paths.get(hjjczzDataPath);
        if(Files.notExists(rootLocation)){
            Files.createDirectories(rootLocation);
        }
        Path path = rootLocation.resolve(fileName);
        File file1 = path.toFile();
        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file1),"UTF-8")
        );
        writer.write(exResultData);
        writer.flush();
        writer.close();
        return null;
    }

    /**
     * 读物特定路径文件，将数据反序列化为Json对象
     * @return
     * @throws IOException
     */
    @Override
    public JSONObject readHjjczzDataCache(String fileName) throws IOException {
        String cacheFilePath = System.getProperty("catalina.home") + DATA_PATH + fileName;
        log.info("环境监测指标缓存文件路径:{}", cacheFilePath);
        String json = FileUtil.readJsonFile(cacheFilePath );
        JSONObject resultData = (JSONObject) JSON.parse(json);
        log.info("环境监测指标数据Json:{}", resultData.toString());
        return resultData;
    }

    @Override
    public JSONObject readHjjczzDataCacheEchatrs(String year,String fileName) throws IOException {
        String cacheFilePath = System.getProperty("catalina.home") + DATA_PATH + fileName + year;
        log.info("环境监测指标缓存文件路径:{}", cacheFilePath);
        String json = FileUtil.readJsonFile(cacheFilePath );
        JSONObject resultData = (JSONObject) JSON.parse(json);
        //log.info("环境监测指标数据Json:{}", resultData.toString());
        return resultData;
    }

    @Override
    public JSONObject GridDataUpdate(String xzqdm, String year0,String year1,String type) throws IOException {
        JSONObject datalist = new JSONObject();
        datalist.put("grid1",Grid1DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid2",Grid2DataUpdate(year0,year1));
       try {
           datalist.put("grid3",Grid3DataUpdate(xzqdm,type));
       } catch (SQLException e) {
         e.printStackTrace();
       }
       datalist.put("grid4",Grid4DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid5",Grid5DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid6",Grid6DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid7",Grid7DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid8",Grid8DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid9",Grid9DataUpdate(xzqdm,year0,year1,type));
       datalist.put("grid10",Grid10DataUpdate(xzqdm,year0,year1,type));
        datalist.put("grid11",Grid11DataUpdate(xzqdm,year0,year1,type));
        try {
            datalist.put("EIchange",getEIBHDataUpdate(year0,year1,type));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datalist;
    }
    public JSONObject Grid1DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException {
        Map<String,String> str=new HashMap<>();
        str.put("ldmj","林地");
        str.put("gdmj","耕地");
        str.put("cdmj","草地");
        str.put("symj","水域");
        str.put("ncjmyd","居民用地");
        str.put("wlytdmj","未利用");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzTdlyExample tHjcczzTdlyExample = new THjjczzTdlyExample();
        THjjczzTdlyExample tHjcczzTdlyExample1 = new THjjczzTdlyExample();

        THjjczzTdlyExample.Criteria criteria = tHjcczzTdlyExample.createCriteria();
        THjjczzTdlyExample.Criteria criteria1 = tHjcczzTdlyExample1.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);
        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);
        List<THjjczzTdly> tHjcczzTdlyList = tHjcczzTdlyMapper.selectByExample(tHjcczzTdlyExample);
        List<THjjczzTdly> tHjcczzTdlyList1 = tHjcczzTdlyMapper.selectByExample(tHjcczzTdlyExample1);

        for(String YAxis0:YAxis)
        {
           double value0=Double.parseDouble(tHjcczzTdlyList.get(0).getFieldValueByName(YAxis0,tHjcczzTdlyList.get(0)).toString());
           double value1=Double.parseDouble(tHjcczzTdlyList1.get(0).getFieldValueByName(YAxis0,tHjcczzTdlyList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    @Autowired
    private THjjczzTdzyjzMapper tdzyjzMapper;
    public JSONObject Grid2RDataUpdate(String year0,String year1) throws IOException {
        //避免无值的现象
        int year0_int=Integer.parseInt(year0);
        int year1_int=Integer.parseInt(year1);
        if(Math.abs(year1_int-year0_int)!=1)
        {

            if(year0_int==2020)
            {
                year0_int=2019;
                year0=year0_int+"";
            }
                year1_int=year0_int+1;
                year1=year1_int+"";
        }else
        {
            if(year0_int>year1_int)
            {
                year0=year1_int+"";
                year1=year0_int+"";
            }
        }
        JSONObject data = new JSONObject();
        Map<String,String> str=new HashMap<>();
        str.put("gd","耕地");
        str.put("ld","林地");
        str.put("cd","草地");
        str.put("sy","水域");
        str.put("jsyd","城乡、工矿、居民用地");
        str.put("wly","未利用土地");
        List<String> XAxis=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        List<String> YAxis_1=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){

            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
            THjjczzTdzyjzExample example=new THjjczzTdzyjzExample();
            THjjczzTdzyjzExample.Criteria criteria=example.createCriteria();
            criteria.andZylxLike("出").andStartYearEqualTo(Integer.parseInt(year0))
                    .andEndYearEqualTo(Integer.parseInt(year1)).andTdlylxLike(entry.getValue());
            List<THjjczzTdzyjz> list=tdzyjzMapper.selectByExample(example);
            if(list.size()>0)
            {
                YAxis_1.add(list.get(0).getFieldValueByName(entry.getKey(),list.get(0)).toString());
                List<Double> YAxis_value=new ArrayList<>();
                for(Map.Entry<String, String> entry1 : str.entrySet())
                {
                    if(entry1.getKey().equals(entry.getKey()))
                    {
                        YAxis_value.add(0.0);
                    }else
                    {
                        YAxis_value.add(Double.parseDouble(list.get(0).
                                getFieldValueByName(entry1.getKey(),list.get(0)).toString()));
                    }
                }
                data.put(entry.getKey(),YAxis_value);
            }
        }
        data.put("BB",YAxis_1);
        data.put("xAxis",XAxis);
        return data;
    }

    public JSONObject Grid2LDataUpdate( String year0,String year1) throws IOException {
        //避免无值的现象
        int year0_int=Integer.parseInt(year0);
        int year1_int=Integer.parseInt(year1);
        if(Math.abs(year1_int-year0_int)!=1)
        {
            if(year0_int==2020)
            {
                year0_int=2019;
                year0=year0_int+"";
            }
            year1_int=year0_int+1;
            year1=year1_int+"";
        }else
        {
            if(year0_int>year1_int)
            {
                year0=year1_int+"";
                year1=year0_int+"";
            }
        }
        JSONObject data = new JSONObject();
        Map<String,String> str=new HashMap<>();
        str.put("gd","耕地");
        str.put("ld","林地");
        str.put("cd","草地");
        str.put("sy","水域");
        str.put("jsyd","城乡、工矿、居民用地");
        str.put("wly","未利用土地");
        List<String> XAxis=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        List<String> YAxis_1=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){

            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
            THjjczzTdzyjzExample example=new THjjczzTdzyjzExample();
            THjjczzTdzyjzExample.Criteria criteria=example.createCriteria();
            criteria.andZylxLike("入").andStartYearEqualTo(Integer.parseInt(year0))
                    .andEndYearEqualTo(Integer.parseInt(year1)).andTdlylxLike(entry.getValue());
            List<THjjczzTdzyjz> list=tdzyjzMapper.selectByExample(example);
            if(list.size()>0)
            {
                YAxis_1.add(list.get(0).getFieldValueByName(entry.getKey(),list.get(0)).toString());
                List<Double> YAxis_value=new ArrayList<>();
                for(Map.Entry<String, String> entry1 : str.entrySet())
                {
                    if(entry1.getKey().equals(entry.getKey()))
                    {
                        YAxis_value.add(0.0);
                    }else
                    {
                        double value=0.0-Double.parseDouble(list.get(0).
                                getFieldValueByName(entry1.getKey(),list.get(0)).toString());
                        YAxis_value.add(value);
                    }
                }
                data.put(entry.getKey(),YAxis_value);
            }
        }
        data.put("xAxis",XAxis);
        return data;
    }

    public JSONObject Grid2DataUpdate( String year0,String year1) throws IOException {
        //避免无值的现象
        int year0_int=Integer.parseInt(year0);
        int year1_int=Integer.parseInt(year1);
        if(Math.abs(year1_int-year0_int)!=1)
        {
            if(year0_int==2020)
            {
                year0_int=2019;
                year0=year0_int+"";
            }
            year1_int=year0_int+1;
            year1=year1_int+"";
        }else
        {
            if(year0_int>year1_int)
            {
                year0=year1_int+"";
                year1=year0_int+"";
            }
        }
        JSONObject data = new JSONObject();
        Map<String,String> str=new HashMap<>();
        str.put("gd","耕地");
        str.put("wly","未利用土地");
        str.put("cd","草地");
        str.put("jsyd","城乡、工矿、居民用地");
        str.put("ld","林地");
        str.put("sy","水域");
        List<JSONObject> data1=new ArrayList<>();
        List<JSONObject> data2=new ArrayList<>();
        List<String> XAxis=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet())
        {
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }
        Set<String> names= new HashSet<String>();
        for(String X:XAxis)
        {
            /*JSONObject temp0=new JSONObject();
            temp0.put("name",X+year0);
            data1.add(temp0);
            JSONObject temp1=new JSONObject();
            temp1.put("name",X+year1);
            data1.add(temp1);*/
            for(String Y:YAxis)
            {
                JSONObject temp3=new JSONObject();
                temp3.put("source",X+year0);
                temp3.put("target",str.get(Y)+year1);
                THjjczzTdzyjzExample example=new THjjczzTdzyjzExample();
                THjjczzTdzyjzExample.Criteria criteria=example.createCriteria();
                criteria.andZylxLike("入").andStartYearEqualTo(Integer.parseInt(year0))
                        .andEndYearEqualTo(Integer.parseInt(year1)).andTdlylxLike(X);
                List<THjjczzTdzyjz> list=tdzyjzMapper.selectByExample(example);
                if(list.size()>0)
                {
                    double value=Double.parseDouble(list.get(0).getFieldValueByName(Y,list.get(0))+"");
                    temp3.put("value",value);
                    if(value>0)
                    {
                        names.add(X+year0);
                        names.add(str.get(Y)+year1);
                        data2.add(temp3);
                    }
                }
            }
        }
        //set遍历
        for (String name : names) {
            JSONObject temp0=new JSONObject();
            temp0.put("name",name);
            data1.add(temp0);
        }
        data.put("city",data1);
        data.put("population",data2);
        return data;
    }

    @Autowired
    private DataSource dataSource;
    public JSONObject Grid3DataUpdate(String xzqdm,String type) throws IOException, SQLException {
        JSONObject datalist = new JSONObject();
        List<String> XAxis=new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        //获取唯一的年份值
        ResultSet resultSet_year = statement.executeQuery
                ("select distinct YEAR from t_hjjczz_ei order by year asc");
        while(resultSet_year.next()){
            String str = resultSet_year.getString("YEAR");
            XAxis.add(str);
        }
        datalist.put("xAxis",XAxis);
        resultSet_year.close();
        /* rs不能交替使用*/
        List<String> pjjgs=new ArrayList<>();
        ResultSet resultSet_pjjg = statement.executeQuery
                ("select distinct PJJG from t_hjjczz_ei");
        while(resultSet_pjjg.next()){
            String str = resultSet_pjjg.getString("PJJG");
            pjjgs.add(str);
        }
        resultSet_pjjg.close();
        if(type.length()>0)
        {
            for(String str:pjjgs)
            {
                ResultSet resultSettemp = statement.executeQuery
                        ("select A.year,ifnull(B.num,0) as geshu "+
                                " from (SELECT DISTINCT YEAR  FROM hjjczz.t_hjjczz_ei order by year asc)A LEFT JOIN("+
                                "select YEAR ,count(XH) as num from hjjczz.t_hjjczz_ei "+
                                "where  (PJJG like '"+str+"' and type like '"+type+"')"+
                                "group by YEAR) B on A.YEAR=B.YEAR");
                List<Double> YAxis_value=new ArrayList<>();
                while(resultSettemp.next()){
                    String value = resultSettemp.getString("geshu");
                    YAxis_value.add(Double.parseDouble(value));
                }
                switch(str){
                    case "优" :
                        datalist.put("xqgsyou",YAxis_value);
                        break; //可选
                    case "良" :
                        datalist.put("xqgsliang",YAxis_value);
                        break; //可选
                    case "一般" :
                        datalist.put("xqgsyiban",YAxis_value);
                        break; //可选
                    case "较差" :
                        datalist.put("xqgsjiaocha",YAxis_value);
                        break; //可选
                    default : //可选
                        break;
                }
                datalist.put(str,YAxis_value);
                resultSettemp.close();
            }
            statement.close();
            connection.close();
        }
        else
        {
            String xzqdmori=xzqdm;
            if(xzqdm.endsWith("0000"))
            {
                xzqdm=xzqdm.substring(0,2)+"%00";
            }
            else
            {
                xzqdm=xzqdm.substring(0,4)+"%";
            }
            for(String str:pjjgs)
            {
                ResultSet resultSettemp = statement.executeQuery
                        ("select A.year,ifnull(B.num,0) as geshu "+
                                " from (SELECT DISTINCT YEAR  FROM hjjczz.t_hjjczz_ei order by year asc)A LEFT JOIN("+
                                "select YEAR ,count(XH) as num from hjjczz.t_hjjczz_ei "+
                                "where  (PJJG like '"+str+"' and XZQDM like '"+xzqdm+"'and XZQDM != '"+ xzqdmori+"')"+
                                "group by YEAR) B on A.YEAR=B.YEAR");
                List<Double> YAxis_value=new ArrayList<>();
                while(resultSettemp.next()){
                    String value = resultSettemp.getString("geshu");
                    YAxis_value.add(Double.parseDouble(value));
                }
                switch(str){
                    case "优" :
                        datalist.put("xqgsyou",YAxis_value);
                        break; //可选
                    case "良" :
                        datalist.put("xqgsliang",YAxis_value);
                        break; //可选
                    case "一般" :
                        datalist.put("xqgsyiban",YAxis_value);
                        break; //可选
                    case "较差" :
                        datalist.put("xqgsjiaocha",YAxis_value);
                        break; //可选
                    default : //可选
                        break;
                }
                datalist.put(str,YAxis_value);
                resultSettemp.close();
            }
            statement.close();
            connection.close();
        }
        return datalist;
    }

    public List<JSONObject> Grid4DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException {

        JSONObject datalist = new JSONObject();
        List<JSONObject> datas=new ArrayList<>();
        //获取第一年
        THjjczzSthjzleiExample example =new THjjczzSthjzleiExample();
        THjjczzSthjzleiExample.Criteria criteria = example.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike(year0).andTypeLike(type);
        List<THjjczzSthjzlei> THjjczzSthjzleilist = mapper.selectByExample(example);
        if(THjjczzSthjzleilist.size()>0)
        {
            JSONObject temp = new JSONObject();
            temp.put("name","EI"+year0);
            temp.put("value",df.format(THjjczzSthjzleilist.get(0).getSthjzkzsei()));
            datas.add(temp);
            JSONObject temp1 = new JSONObject();
            temp1.put("name","评价结果"+year0);
            temp1.put("value",THjjczzSthjzleilist.get(0).getPjjg());
            datas.add(temp1);
        }
        //获取后一年
        THjjczzSthjzleiExample example1 =new THjjczzSthjzleiExample();
        THjjczzSthjzleiExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andXzqdmLike(xzqdm).andYearLike(year1).andTypeLike(type);
        List<THjjczzSthjzlei> THjjczzSthjzleilist1 = mapper.selectByExample(example1);
        if(THjjczzSthjzleilist1.size()>0)
        {
            JSONObject temp = new JSONObject();
            temp.put("name","EI"+year1);
            temp.put("value",df.format(THjjczzSthjzleilist1.get(0).getSthjzkzsei()));
            datas.add(temp);
            JSONObject temp1 = new JSONObject();
            temp1.put("name","评价结果"+year1);
            temp1.put("value",THjjczzSthjzleilist1.get(0).getPjjg());
            datas.add(temp1);
        }
        //获得插值
        if(THjjczzSthjzleilist.size()>0&&THjjczzSthjzleilist1.size()>0)
        {
            JSONObject temp = new JSONObject();
            temp.put("name","△EI");
            double value=THjjczzSthjzleilist1.get(0).getSthjzkzsei()
                    -THjjczzSthjzleilist.get(0).getSthjzkzsei();
            temp.put("value",df.format(value));
            datas.add(temp);
            if(Math.abs(value)<=1)
            {
                JSONObject temp1 = new JSONObject();
                temp1.put("name","变化分级");
                temp1.put("value","无明显变化");
                datas.add(temp1);
            }else if(Math.abs(value)>=1&&Math.abs(value)<3){
                JSONObject temp1 = new JSONObject();
                temp1.put("name","变化分级");
                if(value>0)
                {
                    temp1.put("value","略微变好");
                }else
                {
                    temp1.put("value","略微变差");
                }
                datas.add(temp1);
                }
            else  if(Math.abs(value)>=3&&Math.abs(value)<8){
                JSONObject temp1 = new JSONObject();
                temp1.put("name","变化分级");
                if(value>0)
                {
                    temp1.put("value","明显变好");
                }else
                {
                    temp1.put("value","明显变差");
                }
                datas.add(temp1);
            } else  if(Math.abs(value)>=8){
                JSONObject temp1 = new JSONObject();
                temp1.put("name","变化分级");
                if(value>0)
                {
                    temp1.put("value","显著变好");
                }else
                {
                    temp1.put("value","显著变差");
                }
                datas.add(temp1);
            }
        }
        return datas;
    }

    public JSONObject Grid5DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("swfdzs","生物丰度");
        str.put("zbfgzs","植被覆盖");
        str.put("swmdzs","水网密度");
        str.put("tdxpzs","土地胁迫");
        str.put("wrfhzs","污染负荷");
        /*str.put("hjxzzs","环境限制");*/

        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzSthjzleiExample tHjjczzSthjzleiExample = new THjjczzSthjzleiExample();
        THjjczzSthjzleiExample tHjjczzSthjzleiExample1 = new THjjczzSthjzleiExample();

        THjjczzSthjzleiExample.Criteria criteria = tHjjczzSthjzleiExample.createCriteria();
        THjjczzSthjzleiExample.Criteria criteria1 = tHjjczzSthjzleiExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);
        List<THjjczzSthjzlei> THjjczzSthjzleiList = mapper.selectByExample(tHjjczzSthjzleiExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);
        List<THjjczzSthjzlei> THjjczzSthjzleiList1 = mapper.selectByExample(tHjjczzSthjzleiExample1);

        for(String YAxis0:YAxis)
        {
            String value0_str=THjjczzSthjzleiList.get(0).getFieldValueByName(YAxis0,THjjczzSthjzleiList.get(0)).toString();
            String value1_str=THjjczzSthjzleiList1.get(0).getFieldValueByName(YAxis0,THjjczzSthjzleiList1.get(0)).toString();
            double value0=Double.parseDouble(value0_str);
            double value1=Double.parseDouble(value1_str);
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    @Autowired
    private THjjczzSwfdzsMapper tHjjczzSwfdzsMapper ;
    public JSONObject Grid6DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        if(xzqdm.length()>0)
        {
            xzqdm=xzqdm+"%";
        }
        Map<String,String> str=new HashMap<>();
        str.put("sjzlz","生境质量值");
        str.put("sjzlzs","生境质量指数");
        str.put("swdyxzs","生物多样性指数");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzSwfdzsExample tHjjczzSwfdzsExample = new THjjczzSwfdzsExample();
        THjjczzSwfdzsExample tHjjczzSwfdzsExample1 = new THjjczzSwfdzsExample();

        THjjczzSwfdzsExample.Criteria criteria = tHjjczzSwfdzsExample.createCriteria();
        THjjczzSwfdzsExample.Criteria criteria1 = tHjjczzSwfdzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);
        List<THjjczzSwfdzs> THjjczzSwfdzsList = tHjjczzSwfdzsMapper.selectByExample(tHjjczzSwfdzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);
        List<THjjczzSwfdzs> THjjczzSwfdzsList1 = tHjjczzSwfdzsMapper.selectByExample(tHjjczzSwfdzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzSwfdzsList.get(0).getFieldValueByName(YAxis0,THjjczzSwfdzsList.get(0)).toString());
            double value1=Double.parseDouble(THjjczzSwfdzsList1.get(0).getFieldValueByName(YAxis0,THjjczzSwfdzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    @Autowired
    private THjjczzZbfgzsMapper tHjjczzZbfgzsMapper;
    public JSONObject Grid7DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("ndvi","NDVI指数");
        str.put("zbfgzs","植被覆盖指数");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }
        THjjczzZbfgzsExample tHjjczzZbfgzsExample = new THjjczzZbfgzsExample();
        THjjczzZbfgzsExample tHjjczzZbfgzsExample1 = new THjjczzZbfgzsExample();

        THjjczzZbfgzsExample.Criteria criteria = tHjjczzZbfgzsExample.createCriteria();
        THjjczzZbfgzsExample.Criteria criteria1 = tHjjczzZbfgzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);;
        List<THjjczzZbfgzs> tHjjczzZbfgzsList = tHjjczzZbfgzsMapper.selectByExample(tHjjczzZbfgzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);;
        List<THjjczzZbfgzs> tHjjczzZbfgzsList1 = tHjjczzZbfgzsMapper.selectByExample(tHjjczzZbfgzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(tHjjczzZbfgzsList.get(0).getFieldValueByName(YAxis0,tHjjczzZbfgzsList.get(0)).toString());
            double value1=Double.parseDouble(tHjjczzZbfgzsList1.get(0).getFieldValueByName(YAxis0,tHjjczzZbfgzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    @Autowired
    private THjjczzTdxpzsMapper tHjjczzTdxpzsMapper;
    public JSONObject Grid8DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("tdxpz","土地胁迫值");
        str.put("tdxpzs","土地胁迫指数");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzTdxpzsExample tdxpzsExample = new THjjczzTdxpzsExample();
        THjjczzTdxpzsExample tdxpzsExample1 = new THjjczzTdxpzsExample();

        THjjczzTdxpzsExample.Criteria criteria = tdxpzsExample.createCriteria();
        THjjczzTdxpzsExample.Criteria criteria1 = tdxpzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);;
        List<THjjczzTdxpzs> THjjczzTdxpzsList = tHjjczzTdxpzsMapper.selectByExample(tdxpzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);;
        List<THjjczzTdxpzs> THjjczzTdxpzsList1 = tHjjczzTdxpzsMapper.selectByExample(tdxpzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzTdxpzsList.get(0).getFieldValueByName(YAxis0,THjjczzTdxpzsList.get(0)).toString());
            double value1=Double.parseDouble(THjjczzTdxpzsList1.get(0).getFieldValueByName(YAxis0,THjjczzTdxpzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    @Autowired
    private THjjczzWrfhzsMapper tHjjczzWrfhzsMapper;
    public JSONObject Grid9DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("codpfl","COD");
        str.put("adpfl","氨氮");
        str.put("eyhlpfl","SO2");
        str.put("yfcpfl","烟尘");
        str.put("dyhwpfl","氮氧");
        str.put("gtfqwdql","固废");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzWrfhzsExample tHjjczzWrfhzsExample = new THjjczzWrfhzsExample();
        THjjczzWrfhzsExample tHjjczzWrfhzsExample1 = new THjjczzWrfhzsExample();

        THjjczzWrfhzsExample.Criteria criteria = tHjjczzWrfhzsExample.createCriteria();
        THjjczzWrfhzsExample.Criteria criteria1 = tHjjczzWrfhzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);;
        List<THjjczzWrfhzs> THjjczzWrfhzsList = tHjjczzWrfhzsMapper.selectByExample(tHjjczzWrfhzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);;
        List<THjjczzWrfhzs> THjjczzWrfhzsList1 = tHjjczzWrfhzsMapper.selectByExample(tHjjczzWrfhzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzWrfhzsList.get(0).getFieldValueByName(YAxis0,THjjczzWrfhzsList.get(0)).toString());
            double value1=Double.parseDouble(THjjczzWrfhzsList1.get(0).getFieldValueByName(YAxis0,THjjczzWrfhzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;

    }

    @Autowired
    private THjjczzHjxzzsMapper tHjjczzHjxzzsMapper;
    public JSONObject Grid10DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("hjxzzs","环境限制指数");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzHjxzzsExample THjjczzHjxzzsExample = new THjjczzHjxzzsExample();
        THjjczzHjxzzsExample THjjczzHjxzzsExample1 = new THjjczzHjxzzsExample();

        THjjczzHjxzzsExample.Criteria criteria = THjjczzHjxzzsExample.createCriteria();
        THjjczzHjxzzsExample.Criteria criteria1 = THjjczzHjxzzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);;
        List<THjjczzHjxzzs> THjjczzHjxzzsList = tHjjczzHjxzzsMapper.selectByExample(THjjczzHjxzzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);;
        List<THjjczzHjxzzs> THjjczzHjxzzsList1 = tHjjczzHjxzzsMapper.selectByExample(THjjczzHjxzzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzHjxzzsList.get(0).getFieldValueByName(YAxis0,THjjczzHjxzzsList.get(0)).toString());
            double value1=Double.parseDouble(THjjczzHjxzzsList1.get(0).getFieldValueByName(YAxis0,THjjczzHjxzzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;

    }
    @Autowired
    private THjjczzSwmdzsMapper tHjjczzSwmdzsMapper;
    public JSONObject Grid11DataUpdate(String xzqdm, String year0,String year1,String type) throws IOException{
        Map<String,String> str=new HashMap<>();
        str.put("hlcd","河流长度");
        str.put("hkmj","湖库面积");
        str.put("szyl","水资源量");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }

        THjjczzSwmdzsExample tHjjczzSwmdzsExample = new THjjczzSwmdzsExample();
        THjjczzSwmdzsExample tHjjczzSwmdzsExample1 = new THjjczzSwmdzsExample();

        THjjczzSwmdzsExample.Criteria criteria = tHjjczzSwmdzsExample.createCriteria();
        THjjczzSwmdzsExample.Criteria criteria1 = tHjjczzSwmdzsExample1.createCriteria();

        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year0+"%").andTypeLike(type);;
        List<THjjczzSwmdzs> THjjczzSwmdzsList = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample);

        criteria1.andXzqdmLike(xzqdm).andYearLike("%"+year1+"%").andTypeLike(type);;
        List<THjjczzSwmdzs> THjjczzSwmdzsList1 = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample1);

        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzSwmdzsList.get(0).getFieldValueByName(YAxis0,THjjczzSwmdzsList.get(0)).toString());
            double value1=Double.parseDouble(THjjczzSwmdzsList1.get(0).getFieldValueByName(YAxis0,THjjczzSwmdzsList1.get(0)).toString());
            YAxis_value.add(value1-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public List<JSONObject> getEIBHDataUpdate(String year0,String year1,String type) throws IOException, SQLException {
        List<JSONObject> datas = new ArrayList<>();
        List<String> XAxis = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        //获取唯一的年份值
        ResultSet resultSet_year = statement.executeQuery
                ("select distinct XZQMC from t_hjjczz_sthjzlei where type like '"+type+"'");
        while (resultSet_year.next()) {
            String str = resultSet_year.getString("XZQMC");
            XAxis.add(str);
        }
        resultSet_year.close();
        statement.close();
        connection.close();
        for (String name : XAxis) {
            JSONObject json = new JSONObject();
            json.put("name", name);
            THjjczzSthjzleiExample example = new THjjczzSthjzleiExample();
            THjjczzSthjzleiExample.Criteria criteria = example.createCriteria();
            criteria.andXzqmcLike(name).andYearLike(year0).andTypeLike(type);
            List<THjjczzSthjzlei> THjjczzSthjzleilist = mapper.selectByExample(example);

            THjjczzSthjzleiExample example1 = new THjjczzSthjzleiExample();
            THjjczzSthjzleiExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andXzqmcLike(name).andYearLike(year1).andTypeLike(type);
            List<THjjczzSthjzlei> THjjczzSthjzleilist1 = mapper.selectByExample(example1);

            //获得插值
            if (THjjczzSthjzleilist.size() > 0 && THjjczzSthjzleilist1.size() > 0) {
                double value = THjjczzSthjzleilist1.get(0).getSthjzkzsei()
                        - THjjczzSthjzleilist.get(0).getSthjzkzsei();
                if (Math.abs(value) <= 1) {
                    json.put("value", "无明显变化");
                } else if (Math.abs(value) >= 1 && Math.abs(value) < 3) {
                    if (value > 0) {
                        json.put("value", "略微变好");
                    } else {
                        json.put("value", "略微变差");
                    }

                } else if (Math.abs(value) >= 3 && Math.abs(value) < 8) {

                    if (value > 0) {
                        json.put("value", "明显变好");
                    } else {
                        json.put("value", "明显变差");
                    }
                } else if (Math.abs(value) >= 8) {

                    if (value > 0) {
                        json.put("value", "显著变好");
                    } else {
                        json.put("value", "显著变差");
                    }
                }
            }
            datas.add(json);
        }
        return datas;
    }

}
