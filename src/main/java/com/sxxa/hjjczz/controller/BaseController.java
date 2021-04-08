package com.sxxa.hjjczz.controller;

import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.util.ContextUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
@Log4j2
public class BaseController {

    public JSONObject serializeToSuccessJson(Object obj, String message){
        JSONObject map = new JSONObject();
        map.put(ContextUtil.HTTP_RESPONSE_STATUS, ContextUtil.STATUS_SCCESS);
        map.put(ContextUtil.HTTP_RESPONSE_MESSAGE, message);
        map.put("data", obj);
        return map;
    }

    public JSONObject serializeToFailedJson(Object obj, String message){
        JSONObject map = new JSONObject();

        map.put(ContextUtil.HTTP_RESPONSE_STATUS, ContextUtil.STATUS_FAILED);
        map.put(ContextUtil.HTTP_RESPONSE_MESSAGE, message);
        map.put("data", obj);

        return map;
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
