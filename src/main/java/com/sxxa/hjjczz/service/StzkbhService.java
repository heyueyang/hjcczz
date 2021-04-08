package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface StzkbhService {
    JSONObject stzkbhData(String xzqdm, List<String> chartTypeValueList);

    JSONObject getStzkbhData(String xzqdm, String chartTypeKey);
}
