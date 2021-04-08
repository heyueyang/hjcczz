package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.dao.*;
import com.sxxa.hjjczz.entity.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class stzkpjServiceImp implements stzkpjService{

    @Autowired
    private THjjczzSthjzleiMapper tHjjczzSthjzleiMapper ;
    @Autowired
    private THjjczzTdxpzsMapper tHjjczzTdxpzsMapper ;
    @Autowired
    private THjjczzSwfdzsMapper tHjjczzSwfdzsMapper ;
    @Autowired
    private THjjczzSwmdzsMapper tHjjczzSwmdzsMapper ;
    @Autowired
    private THjjczzEiMapper tHjjczzEiMapper ;
    @Autowired
    private THjjczzWrfhzsMapper tHjjczzWrfhzsMapper ;
    @Autowired
    private THjjczzZbfgzsMapper tHjjczzZbfgzsMapper ;
    @Autowired
    private THjjczzHjxzzsMapper tHjjczzHjxzzsMapper ;
    @Autowired
    private THjjczzTdlyMapper tHjjczzTdlyMapper;
    @Autowired
    private THjjczzGdpMapper tHjjczzGdpMapper;
    @Autowired
    private THjjczzRktjMapper tHjjczzRktjMapper;
    @Autowired
    private THjjczzAreaMapper tHjjczzAreaMapper;
    @Autowired
    private THjjczzTdlyMapper tHjcczzTdlyMapper;
    @Override
    public JSONObject stzkpjDataUpdate(String xzqdm,String type,String year) {
        JSONObject data = new JSONObject();
        if(type.equals("sthjzs")){
            THjjczzSthjzleiExample tHjjczzSthjzleiExample = new THjjczzSthjzleiExample();
            THjjczzSthjzleiExample.Criteria criteria = tHjjczzSthjzleiExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzSthjzlei> THjjczzSthjzleiList = tHjjczzSthjzleiMapper.selectByExample(tHjjczzSthjzleiExample);
            data.put("oridata", THjjczzSthjzleiList);
            return data;

        }
        else if(type.equals("tdxpzs")){
            THjjczzTdxpzsExample tHjjczzTdxpzsExample = new THjjczzTdxpzsExample();
            THjjczzTdxpzsExample.Criteria criteria = tHjjczzTdxpzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzTdxpzs> THjjczzTdxpzsList = tHjjczzTdxpzsMapper.selectByExample(tHjjczzTdxpzsExample);
            data.put("oridata", THjjczzTdxpzsList);
            return data;
        }
        else if(type.equals("swfdzs")){
            THjjczzSwfdzsExample tHjjczzSwfdzsExample = new THjjczzSwfdzsExample();
            THjjczzSwfdzsExample.Criteria criteria = tHjjczzSwfdzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzSwfdzs> THjjczzSwfdzsList = tHjjczzSwfdzsMapper.selectByExample(tHjjczzSwfdzsExample);
            data.put("oridata", THjjczzSwfdzsList);
            return data;
        }
        else if(type.equals("swmdzsleft") ||type.equals("swmdzsright")){
            THjjczzSwmdzsExample tHjjczzSwmdzsExample = new THjjczzSwmdzsExample();
            THjjczzSwmdzsExample.Criteria criteria = tHjjczzSwmdzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzSwmdzs> THjjczzSwmdzsList = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample);
            data.put("oridata", THjjczzSwmdzsList);
            return data;
        }
        else if(type.equals("sthjzlei")){
//            THjjczzEiExample tHjjczzEiExample = new THjjczzEiExample();
//            THjjczzEiExample.Criteria criteria = tHjjczzEiExample.createCriteria();
//            criteria.andXzqdmLike("%"+xzqdm+"%");
//            criteria.andYearLike("%"+year+"%");
//            List<THjjczzEi> tHjjczzEiList = tHjjczzEiMapper.selectByExample(tHjjczzEiExample);
//            data.put("oridata", tHjjczzEiList);
            THjjczzSthjzleiExample tHjjczzSthjzleiExample = new THjjczzSthjzleiExample();
            THjjczzSthjzleiExample.Criteria criteria =tHjjczzSthjzleiExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzSthjzlei> THjjczzSthjzleiList = tHjjczzSthjzleiMapper.selectByExample(tHjjczzSthjzleiExample);
            data.put("oridata", THjjczzSthjzleiList);
            return data;
        }
        else if(type.equals("ei")){
            THjjczzEiExample tHjjczzEiExample = new THjjczzEiExample();
            THjjczzEiExample.Criteria criteria = tHjjczzEiExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%").andTypeLike("");
            List<THjjczzEi> tHjjczzEiList = tHjjczzEiMapper.selectByExample(tHjjczzEiExample);
            data.put("oridata", tHjjczzEiList);
            return data;
        }
        else if(type.equals("wrfhzs")){
            THjjczzWrfhzsExample tHjjczzWrfhzsExample = new THjjczzWrfhzsExample();
            THjjczzWrfhzsExample.Criteria criteria = tHjjczzWrfhzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzWrfhzs> THjjczzWrfhzsList = tHjjczzWrfhzsMapper.selectByExample(tHjjczzWrfhzsExample);
            data.put("oridata", THjjczzWrfhzsList);
            return data;
        }
        else if(type.equals("zbfgzs")){
            THjjczzZbfgzsExample tHjjczzZbfgzsExample = new THjjczzZbfgzsExample();
            THjjczzZbfgzsExample.Criteria criteria = tHjjczzZbfgzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzZbfgzs> THjjczzZbfgzsList = tHjjczzZbfgzsMapper.selectByExample(tHjjczzZbfgzsExample);
            data.put("oridata", THjjczzZbfgzsList);
            return data;
        }
        else if(type.equals("hjxzzs")){
            THjjczzHjxzzsExample tHjjczzHjxzzsExample = new THjjczzHjxzzsExample();
            THjjczzHjxzzsExample.Criteria criteria = tHjjczzHjxzzsExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzHjxzzs> THjjczzHjxzzsList = tHjjczzHjxzzsMapper.selectByExample(tHjjczzHjxzzsExample);
            data.put("oridata", THjjczzHjxzzsList);
            return data;
        }
        else if(type.equals("tdly")){
            THjjczzTdlyExample tHjjczzTdlyExample = new THjjczzTdlyExample();
            THjjczzTdlyExample.Criteria criteria = tHjjczzTdlyExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%").andTypeLike("");
            List<THjjczzTdly> tHjjczzTdlyList = tHjjczzTdlyMapper.selectByExample(tHjjczzTdlyExample);
            data.put("oridata", tHjjczzTdlyList);
            return data;
        }
        else if(type.equals("gdp")){
            THjjczzGdpExample tHjcczzGdpExample = new THjjczzGdpExample();
            THjjczzGdpExample.Criteria criteria = tHjcczzGdpExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%");
            List<THjjczzGdp> THjjczzGdpList = tHjjczzGdpMapper.selectByExample(tHjcczzGdpExample);
            data.put("oridata", THjjczzGdpList);
            return data;
        }
        else if(type.equals("rktj")){
            THjjczzRktjExample tHjjczzRktjExample = new THjjczzRktjExample();
            THjjczzRktjExample.Criteria criteria = tHjjczzRktjExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%");
            List<THjjczzRktj> THjjczzRktjList = tHjjczzRktjMapper.selectByExample(tHjjczzRktjExample);
            data.put("oridata", THjjczzRktjList);
            return data;
        }
        else if(type.equals("area")){
            THjjczzAreaExample tHjjczzAreaExample = new THjjczzAreaExample();
            THjjczzAreaExample.Criteria criteria = tHjjczzAreaExample.createCriteria();
            criteria.andXzqdmLike("%"+xzqdm+"%");
            criteria.andYearLike("%"+year+"%");
            List<THjjczzArea> THjjczzAreaList = tHjjczzAreaMapper.selectByExample(tHjjczzAreaExample);
            data.put("oridata", THjjczzAreaList);
            return data;
        }
        else{
            return null;
        }

    }
    @Override
    public JSONObject stzkqllypjDataUpdate(String xzqdm,String type,String year) {
        JSONObject datalist = new JSONObject();
        datalist.put("grid1",Grid1DataUpdate(xzqdm,type,year));
        datalist.put("grid2",Grid2DataUpdate(xzqdm,type,year));
        datalist.put("grid4",Grid4DataUpdate(xzqdm,type,year));
        datalist.put("grid5",Grid5DataUpdate(xzqdm,type,year));
        datalist.put("grid6",Grid6DataUpdate(xzqdm,type,year));
        datalist.put("grid7",Grid7DataUpdate(xzqdm,type,year));
        datalist.put("grid8",Grid8DataUpdate(xzqdm,type,year));
        datalist.put("grid9",Grid9DataUpdate(xzqdm,type,year));
        datalist.put("grid10",Grid10DataUpdate(xzqdm,type,year));
        datalist.put("grid11_left",Grid11DataUpdate(xzqdm,type,year));
        datalist.put("grid11_right",Grid12DataUpdate(xzqdm,type,year));
        return datalist;
    }

    public JSONObject Grid1DataUpdate(String xzqdm,String type,String year)  {
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
        THjjczzTdlyExample.Criteria criteria = tHjcczzTdlyExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzTdly> tHjcczzTdlyList = tHjcczzTdlyMapper.selectByExample(tHjcczzTdlyExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(tHjcczzTdlyList.get(0).getFieldValueByName(YAxis0,tHjcczzTdlyList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid2DataUpdate(String xzqdm,String type,String year)  {

        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis=new ArrayList<>();
        THjjczzEiExample tHjjczzEiExample = new THjjczzEiExample();
        THjjczzEiExample.Criteria criteria = tHjjczzEiExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andTypeLike(type);
        List<THjjczzEi> tHjjczzEis = tHjjczzEiMapper.selectByExample(tHjjczzEiExample);
        for(THjjczzEi tHjjczzEi:tHjjczzEis)
        {
            XAxis.add("ei"+tHjjczzEi.getYear());
            YAxis.add(tHjjczzEi.getEi());
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis);
        return datalist;
    }
    public JSONObject Grid4DataUpdate(String xzqdm,String type,String year)  {
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis=new ArrayList<>();
        THjjczzEiExample tHjjczzEiExample = new THjjczzEiExample();
        THjjczzEiExample.Criteria criteria = tHjjczzEiExample.createCriteria();
        if(type.contains("河")||type.equals("全流域"))
        {
            criteria.andYearLike("%"+year+"%").andXzqdmLike("").andTypeLike("%河");
            List<THjjczzEi> tHjjczzEis = tHjjczzEiMapper.selectByExample(tHjjczzEiExample);
            for(THjjczzEi tHjjczzEi:tHjjczzEis)
            {
                XAxis.add(tHjjczzEi.getXzqmc());
                YAxis.add(tHjjczzEi.getEi());
            }

        }else
        {
            criteria.andYearLike("%"+year+"%").andTypeLike(type);
            List<THjjczzEi> tHjjczzEis = tHjjczzEiMapper.selectByExample(tHjjczzEiExample);
            for(THjjczzEi tHjjczzEi:tHjjczzEis)
            {
                if(tHjjczzEi.getXzqmc().length()>0)
                {
                    XAxis.add(tHjjczzEi.getXzqmc());
                    YAxis.add(tHjjczzEi.getEi());
                }
            }
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis);
        return datalist;
    }
    public JSONObject Grid5DataUpdate(String xzqdm,String type,String year)  {
        Map<String,String> str=new HashMap<>();
        str.put("swfdzs","生物丰度");
        str.put("zbfgzs","植被覆盖");
        str.put("swmdzs","水网密度");
        str.put("tdxpzs","土地胁迫");
        str.put("wrfhzs","污染负荷");
        str.put("hjxzzs","环境限制");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }
        THjjczzSthjzleiExample tHjjczzSthjzleiExample = new THjjczzSthjzleiExample();
        THjjczzSthjzleiExample.Criteria criteria = tHjjczzSthjzleiExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzSthjzlei> THjjczzSthjzleiList = tHjjczzSthjzleiMapper.selectByExample(tHjjczzSthjzleiExample);
        for(String YAxis0:YAxis)
        {
            String value0_str=THjjczzSthjzleiList.get(0).getFieldValueByName(YAxis0,THjjczzSthjzleiList.get(0)).toString();
            double value0=Double.parseDouble(value0_str);
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid6DataUpdate(String xzqdm,String type,String year) {

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
        THjjczzSwfdzsExample.Criteria criteria = tHjjczzSwfdzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzSwfdzs> THjjczzSwfdzsList = tHjjczzSwfdzsMapper.selectByExample(tHjjczzSwfdzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzSwfdzsList.get(0).getFieldValueByName(YAxis0,THjjczzSwfdzsList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid7DataUpdate(String xzqdm,String type,String year) {
        Map<String,String> str=new HashMap<>();
        str.put("zbfgzs","植被覆盖指数");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }
        THjjczzZbfgzsExample tHjjczzZbfgzsExample = new THjjczzZbfgzsExample();
        THjjczzZbfgzsExample.Criteria criteria = tHjjczzZbfgzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzZbfgzs> tHjjczzZbfgzsList = tHjjczzZbfgzsMapper.selectByExample(tHjjczzZbfgzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(tHjjczzZbfgzsList.get(0).getFieldValueByName(YAxis0,tHjjczzZbfgzsList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid8DataUpdate(String xzqdm,String type,String year) {
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
        THjjczzTdxpzsExample.Criteria criteria = tdxpzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzTdxpzs> THjjczzTdxpzsList = tHjjczzTdxpzsMapper.selectByExample(tdxpzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzTdxpzsList.get(0).getFieldValueByName(YAxis0,THjjczzTdxpzsList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid9DataUpdate(String xzqdm,String type,String year) {
        List<JSONObject> datas=new ArrayList<>();
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

        THjjczzWrfhzsExample tHjjczzWrfhzsExample = new THjjczzWrfhzsExample();
        THjjczzWrfhzsExample.Criteria criteria = tHjjczzWrfhzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzWrfhzs> THjjczzWrfhzsList = tHjjczzWrfhzsMapper.selectByExample(tHjjczzWrfhzsExample);
        for(Map.Entry<String, String> entry : str.entrySet()){
            JSONObject datalist = new JSONObject();
            datalist.put("name",entry.getValue());
            double value0=Double.parseDouble(THjjczzWrfhzsList.get(0).getFieldValueByName(entry.getKey(),THjjczzWrfhzsList.get(0)).toString());
            datalist.put("value",value0);
            datas.add(datalist);
        }
        JSONObject test = new JSONObject();
        test.put("dataArr",datas);
        return test;
    }

    public JSONObject Grid10DataUpdate(String xzqdm,String type,String year) {
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
        THjjczzHjxzzsExample.Criteria criteria = THjjczzHjxzzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzHjxzzs> THjjczzHjxzzsList = tHjjczzHjxzzsMapper.selectByExample(THjjczzHjxzzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzHjxzzsList.get(0).getFieldValueByName(YAxis0,THjjczzHjxzzsList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;

    }

    public JSONObject Grid11DataUpdate(String xzqdm,String type,String year) {
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
        THjjczzSwmdzsExample.Criteria criteria = tHjjczzSwmdzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzSwmdzs> THjjczzSwmdzsList = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzSwmdzsList.get(0).getFieldValueByName(YAxis0,THjjczzSwmdzsList.get(0)).toString());
            YAxis_value.add(0-value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }

    public JSONObject Grid12DataUpdate(String xzqdm,String type,String year) {
        Map<String,String> str=new HashMap<>();
        str.put("hlzs","河流长度");
        str.put("hkzs","湖库面积");
        str.put("szyzs","水资源量");
        List<String> XAxis=new ArrayList<>();
        List<Double> YAxis_value=new ArrayList<>();
        List<String> YAxis=new ArrayList<>();
        for(Map.Entry<String, String> entry : str.entrySet()){
            XAxis.add(entry.getValue());
            YAxis.add(entry.getKey());
        }
        THjjczzSwmdzsExample tHjjczzSwmdzsExample = new THjjczzSwmdzsExample();
        THjjczzSwmdzsExample.Criteria criteria = tHjjczzSwmdzsExample.createCriteria();
        criteria.andXzqdmLike(xzqdm).andYearLike("%"+year+"%").andTypeLike(type);
        List<THjjczzSwmdzs> THjjczzSwmdzsList = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample);
        for(String YAxis0:YAxis)
        {
            double value0=Double.parseDouble(THjjczzSwmdzsList.get(0).getFieldValueByName(YAxis0,THjjczzSwmdzsList.get(0)).toString());
            YAxis_value.add(value0);
        }
        JSONObject datalist = new JSONObject();
        datalist.put("xAxis",XAxis);
        datalist.put("yAxis",YAxis_value);
        return datalist;
    }
}
