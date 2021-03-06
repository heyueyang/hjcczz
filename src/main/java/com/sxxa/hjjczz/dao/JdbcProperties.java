package com.sxxa.hjjczz.dao;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
public class JdbcProperties {
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
