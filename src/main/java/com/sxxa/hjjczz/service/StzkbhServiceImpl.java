package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.dao.*;
import com.sxxa.hjjczz.entity.*;
import com.sxxa.hjjczz.enums.ChartTypeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class StzkbhServiceImpl implements StzkbhService {

    @Autowired
    private THjjczzGdpMapper tHjjczzGdpMapper;
    @Autowired
    private THjjczzTdlyMapper tHjjczzTdlyMapper;
    @Autowired
    private THjjczzSthjzleiMapper tHjjczzSthjzleiMapper ;
    @Autowired
    private THjjczzTdxpzsMapper tHjjczzTdxpzsMapper ;
    @Autowired
    private THjjczzSwfdzsMapper tHjjczzSwfdzsMapper ;
    @Autowired
    private THjjczzSwmdzsMapper tHjjczzSwmdzsMapper ;
    @Autowired
    private THjjczzWrfhzsMapper tHjjczzWrfhzsMapper ;

    @Override
    public JSONObject stzkbhData(String xzqdm, List<String> chartTypeValueList){
        if(null == xzqdm){
            return null;
        }


        for(String chartTypeKey : chartTypeValueList){
            getStzkbhData(xzqdm, chartTypeKey);
        }

        return null;
    }

    @Override
    public JSONObject getStzkbhData(String xzqdm, String chartTypeKey) {
        log.info("查询数据库入参：xzqdm={},chartTypeKey={}", xzqdm, chartTypeKey);
        JSONObject data = new JSONObject();
        ChartTypeEnum chartTypeEnum = ChartTypeEnum.getEnum(chartTypeKey);
        log.info("chartTypeEnum={}", chartTypeEnum);
        switch (chartTypeEnum){
            case STZKGS: {
            }
            case TDLY: {
                THjjczzTdlyExample tHjjczzTdlyExample = new THjjczzTdlyExample();
                tHjjczzTdlyExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzTdly> tHjjczzTdlyList = tHjjczzTdlyMapper.selectByExample(tHjjczzTdlyExample);
                data.put("oridata", tHjjczzTdlyList);
                return data;
            }
            case STZKMJ: {

            }
            case STZKGDP: {
                THjjczzGdpExample tHjjczzGdpExample = new THjjczzGdpExample();
                tHjjczzGdpExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzGdp> THjjczzSthjzleiList = tHjjczzGdpMapper.selectByExample(tHjjczzGdpExample);
                data.put("oridata", THjjczzSthjzleiList);
                return data;
            }
            case STHJZS: {
                THjjczzSthjzleiExample tHjjczzSthjzleiExample = new THjjczzSthjzleiExample();
                tHjjczzSthjzleiExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzSthjzlei> THjjczzSthjzleiList = tHjjczzSthjzleiMapper.selectByExample(tHjjczzSthjzleiExample);
                data.put("oridata", THjjczzSthjzleiList);
                return data;
            }
            case TDXPZS: {
                THjjczzTdxpzsExample tHjjczzTdxpzsExample = new THjjczzTdxpzsExample();
                tHjjczzTdxpzsExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzTdxpzs> THjjczzTdxpzsList = tHjjczzTdxpzsMapper.selectByExample(tHjjczzTdxpzsExample);
                data.put("oridata", THjjczzTdxpzsList);
                return data;
            }
            case SWFDZS: {
                THjjczzSwfdzsExample tHjjczzSwfdzsExample = new THjjczzSwfdzsExample();
                tHjjczzSwfdzsExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzSwfdzs> THjjczzSwfdzsList = tHjjczzSwfdzsMapper.selectByExample(tHjjczzSwfdzsExample);
                data.put("oridata", THjjczzSwfdzsList);
                return data;
            }
            case SWMDZSLEFT:
            case SWMDZSRIGHT:
                {
                    THjjczzSwmdzsExample tHjjczzSwmdzsExample = new THjjczzSwmdzsExample();
                    tHjjczzSwmdzsExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                    List<THjjczzSwmdzs> THjjczzSwmdzsList = tHjjczzSwmdzsMapper.selectByExample(tHjjczzSwmdzsExample);
                    data.put("oridata", THjjczzSwmdzsList);
                    return data;
            }
            case EIZS:
            case EITJ:{
            }
            case WRFHZS:{
                THjjczzWrfhzsExample tHjjczzWrfhzsExample = new THjjczzWrfhzsExample();
                tHjjczzWrfhzsExample.createCriteria().andXzqdmLike("%"+xzqdm+"%");
                List<THjjczzWrfhzs> THjjczzWrfhzsList = tHjjczzWrfhzsMapper.selectByExample(tHjjczzWrfhzsExample);
                data.put("oridata", THjjczzWrfhzsList);
                return data;
            }


            default:
                log.error("不合法的枚举值: " + chartTypeEnum);
        }
        return null;
    }
}
