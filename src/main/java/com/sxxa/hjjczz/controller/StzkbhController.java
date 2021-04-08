package com.sxxa.hjjczz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.service.StzkbhService;
import com.sxxa.hjjczz.service.stzkpjService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stzkbh")
@Log4j2
@Api(tags = "stzkpj Service Api")
public class StzkbhController extends BaseController{
    @Autowired
    private StzkbhService stzkbhService;
    /**
     * 查询生态环境变化数据
     * @param params
     * @return
     */
    @RequestMapping("/stzkbhData")
    @ResponseBody
    public JSONObject stzkbhDataRequest(@RequestBody Map<String, String> params){
        try{
            log.info("查询生态环境变化数据,入参={}", JSON.toJSONString(params));
            String xzqdm = params.containsKey("xzqdm")?params.get("xzqdm"):"";
            String type = params.containsKey("type")?params.get("type"):"";
            return serializeToSuccessJson(stzkbhService.getStzkbhData(xzqdm,type), "生态环境变化数据，获取成功");
        }catch(Exception ex){
            return serializeToFailedJson(ex.getMessage(), "信息获取异常");
        }
    }
}
