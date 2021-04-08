package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;
import com.sxxa.hjjczz.util.POIUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UtilServiceImp implements UtilService{

    @Override
    public JSONObject ReadExcel(String path) throws Exception {
        log.info("读取一个excel!");
        POIUtil poiUtil = new POIUtil();
        JSONObject obj = new JSONObject();
        String[] pathArr = path.split(",");
        for (int i = 0; i < pathArr.length; i++) {
            String pathFile  = pathArr[i];
            int index = pathFile.lastIndexOf("\\");
            String FileNameE = pathFile.substring(index+1);
            int index1 = FileNameE.lastIndexOf(".");
            String FileName = FileNameE.substring(0,index1);
            log.info( "查询参数：index={},FileName={}", index, FileName);
            obj.put(FileName+"",poiUtil.getRead(pathArr[i]));
        }
        return obj;
    }
}
