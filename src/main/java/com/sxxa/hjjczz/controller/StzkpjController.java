package com.sxxa.hjjczz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.service.stzkpjService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stzkpj")
@Log4j2
@Api(tags = "stzkpj Service Api")
public class StzkpjController extends BaseController{
    @Autowired
    private stzkpjService stzkpjService;

    @RequestMapping("/stzkpjData")
    @ResponseBody
    public JSONObject DataUpdate(@RequestBody Map<String, String> params){
        try{
            log.info("查询数据,入参={}", JSON.toJSONString(params));
            String xzqdm = params.containsKey("xzqdm")?params.get("xzqdm"):"";
            String type = params.containsKey("type")?params.get("type"):"";
            String year = params.containsKey("year")?params.get("year"):"";
            return serializeToSuccessJson(stzkpjService.stzkpjDataUpdate(xzqdm,type,year), "信息获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常。");
        }
    }
    //获取秦岭和流域的现状数据
    @RequestMapping("/stzkQlLypjData")
    @ResponseBody
    public JSONObject QLLYDataUpdate(@RequestBody Map<String, String> params){
        try{
            log.info("查询数据,入参={}", JSON.toJSONString(params));
            String xzqdm = params.containsKey("xzqdm")?params.get("xzqdm"):"";
            String type = params.containsKey("type")?params.get("type"):"";
            String year = params.containsKey("year")?params.get("year"):"";
            return serializeToSuccessJson(stzkpjService.stzkqllypjDataUpdate(xzqdm,type,year), "信息获取成功");
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
