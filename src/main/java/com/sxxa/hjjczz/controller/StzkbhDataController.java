package com.sxxa.hjjczz.controller;


import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.service.DataUpdateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stzkbhUpdate")
@Log4j2
public class StzkbhDataController extends BaseController{

    @Autowired
    private DataUpdateService dataUpdateService ;
    private static final String CACHE_DATA_FILE = "stzkbhData";

    /**
     * 前端点击更新按钮时，将前端组装好的数据缓存至后端
     * @param params
     * @return
     */
    @RequestMapping("/resultDataUpdate")
    @ResponseBody
    public JSONObject DataUpdate(@RequestBody Map<String, String> params){
        try{
            log.info("调用数据更新接口，入参={}", JSONObject.toJSONString(params));
            String exResultData = params.containsKey("exResultData")?params.get("exResultData"):"";
            String year = params.containsKey("year")?params.get("year"):"";
            return serializeToSuccessJson(dataUpdateService.hjjczzDataUpdate(exResultData,CACHE_DATA_FILE), "信息获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常。");
        }
    }

    /**
     * 每次刷新页面时读取缓存文件数据
     * @return
     */
    @RequestMapping("/getHjjczzDataCache")
    public JSONObject getHjjczzData(){
        try{
            log.info("获取环境监测数据缓存信息");
            return serializeToSuccessJson(dataUpdateService.readHjjczzDataCache(CACHE_DATA_FILE), "成功");
        }catch(Exception e){
            log.error("信息获取异常", e);
            return serializeToFailedJson("", "信息获取异常");
        }
    }

    /**
     * 前端请求时，将土地利用数据返回
     * @param params
     * @return
     */
    @RequestMapping("/grid1DataUpdate")
    @ResponseBody
    public JSONObject Grid1DataUpdate(@RequestBody Map<String, String> params){
        try{
            log.info("zjw调用数据更新接口，入参={}", JSONObject.toJSONString(params));
            String year0 = params.containsKey("year0")?params.get("year0"):"";
            String year1 = params.containsKey("year1")?params.get("year1"):"";
            String xzqdm = params.containsKey("xzqdm")?params.get("xzqdm"):"";
            String type = params.containsKey("type")?params.get("type"):"";
            return serializeToSuccessJson
                    (dataUpdateService.GridDataUpdate(xzqdm,year0,year1,type), "信息获取成功");
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
