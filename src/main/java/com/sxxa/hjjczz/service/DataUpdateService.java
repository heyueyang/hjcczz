package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public interface DataUpdateService {
    JSONObject hjjczzDataUpdateEchatrs(String exResultData,String year,String fileName) throws IOException;

    JSONObject hjjczzDataUpdate(String exResultData,String fileName) throws IOException;

    JSONObject readHjjczzDataCacheEchatrs(String year,String fileName) throws IOException;

    JSONObject readHjjczzDataCache(String fileName) throws IOException;

    JSONObject GridDataUpdate(String xzqdm, String year0,String year1,String type) throws IOException;
}

