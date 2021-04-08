package com.sxxa.hjjczz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.service.UtilService;
import com.sxxa.hjjczz.util.POIUtil;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/util")
@Log4j2
@Api(tags = "util Service Api")
public class UtilController  extends BaseController{
    @Autowired
    private UtilService utilService;

    @RequestMapping("/ReadExcel")
    @ResponseBody
    public JSONObject Excel(@RequestBody Map<String, String> params) throws Exception{
        try{
            log.info("查询数据,入参={}", JSON.toJSONString(params));
            String path = params.containsKey("path")?params.get("path"):"";
            return serializeToSuccessJson(utilService.ReadExcel(path), "信息获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常。");
        }

    }
}
