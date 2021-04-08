package com.sxxa.hjjczz.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StzkbhServiceImplTest {

    @Autowired
    private StzkbhService stzkbhService;

    @Test
    void stzkbhData() {
    }

    @Test
    void getStzkbhData() {
        System.out.println("测试查询数据");
        JSONObject data = stzkbhService.getStzkbhData("61", "stzkgdp");
        System.out.println(data);
    }
}