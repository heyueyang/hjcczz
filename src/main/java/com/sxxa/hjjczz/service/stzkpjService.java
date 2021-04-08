package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;

public interface stzkpjService {
    /**
     * 获取环境监测数据
     * @param xzqdm 行政区代码，查询时按照行政区代码模糊匹配
     * @param type 图表类型
     * @return
     */
    JSONObject stzkpjDataUpdate(String xzqdm,String type,String year);
    JSONObject stzkqllypjDataUpdate(String xzqdm,String type,String year);
}
