package com.sxxa.hjjczz.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.service.DataUpdateService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Map;

@RestController
@RequestMapping("/update")
@Log4j2
public class DataUpdateController extends BaseController{

    @Autowired
    private DataUpdateService dataUpdateService ;
    private static final String CACHE_DATA_FILE = "hjcczzData";
    private static final String CACHE_MAPDATA_FILE = "hjcczzMapData";
    /**
     * 前端点击更新按钮时，将前端组装好的数据缓存至后端
     * @param params
     * @return
     */


    @RequestMapping("/resultDataUpdate")
    @ResponseBody
//    @PostMapping("/resultDataUpdate")
    public JSONObject DataUpdate(@RequestBody Map<String, String> params){
        try{
            //log.info("调用数据更新接口，入参={}", JSONObject.toJSONString(params));
            String exResultData = params.containsKey("exResultData")?params.get("exResultData"):"";
            String year = params.containsKey("year")?params.get("year"):"";
            return serializeToSuccessJson(dataUpdateService.hjjczzDataUpdateEchatrs(exResultData, year ,CACHE_DATA_FILE), "信息获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常。");
        }
    }

    /**
     * 每次刷新页面时读取缓存文件数据
     * @return
     */
    @RequestMapping("/getHjjczzDataCache")
    public JSONObject getHjjczzData(@RequestBody Map<String, String> params){
        try{
            log.info("获取环境监测数据缓存信息");
            String year = params.containsKey("year")?params.get("year"):"";
            return serializeToSuccessJson(dataUpdateService.readHjjczzDataCacheEchatrs(year,CACHE_DATA_FILE), "成功");
        }catch(Exception e){
            log.error("信息获取异常", e);
            return serializeToFailedJson("", "信息获取异常");
        }
    }
    @RequestMapping("/getHjjczzMapDataCache")
    public JSONObject getHjjczzMapData(){
        try{
            log.info("获取环境监测数据缓存信息");
            return serializeToSuccessJson(dataUpdateService.readHjjczzDataCache(CACHE_MAPDATA_FILE), "成功");
        }catch(Exception e){
            log.error("信息获取异常", e);
            return serializeToFailedJson("", "信息获取异常");
        }
    }
    @RequestMapping("/resultMapDataUpdate")
    @ResponseBody
    public JSONObject MapDataUpdate(@RequestBody Map<String, String> params){
        try{
            log.info("调用数据更新接口，入参={}", JSONObject.toJSONString(params));
            String exResultData = params.containsKey("exResultData")?params.get("exResultData"):"";
            return serializeToSuccessJson(dataUpdateService.hjjczzDataUpdate(exResultData, CACHE_MAPDATA_FILE), "信息获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常。");
        }
    }
    @RequestMapping("/helloworld")
    public JSONObject helloWorld(){
        log.info("This is a hello world request!");
        JSONObject map = new JSONObject();



        map.put("1", "hello");
        map.put("2", "world");
        map.put("3", "!");
        log.info("This is a hello world response：{}", map);
        return map;
    }
}
