package com.sxxa.hjjczz.enums;

public enum ChartTypeEnum {
    TDLY(1,"tdly","土地利用及变化"),
    STZKMJ(2,"","生态状况类型面积占比与GDP占比"),
    STZKGDP(3,"stzkgdp","生态状况类型GDP占比"),
    STZKGS(4,"","生态状况类型个数"),
    STHJZS(5,"sthjzs","生态环境指数"),
    TDXPZS(5,"tdxpzs","生态环境指数"),
    SWFDZS(5,"swfdzs","生物丰度指数"),
    SWMDZSLEFT(5,"swmdzsleft","生态环境指数"),
    SWMDZSRIGHT(5,"swmdzsright","生态环境指数"),
    EIZS(5,"eizs","EI指数"),
    EITJ(5,"eitj","EI指数"),
    WRFHZS(5,"wrfhzs","生态环境指数");

    int id;
    String key;
    String value;

    ChartTypeEnum(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int getId() { return id; }

    public static ChartTypeEnum getEnum(String key) {
        for (ChartTypeEnum c : ChartTypeEnum.values()) {
            if (key.equals(c.getKey())) {
                return c;
            }
        }
        return null;
    }
}
