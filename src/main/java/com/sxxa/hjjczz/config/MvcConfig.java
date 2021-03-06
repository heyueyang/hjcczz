package com.sxxa.hjjczz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 这里之所以多了一"/",是为了解决打war时访问不到问题
        registry.addResourceHandler("/hjcczz/**").addResourceLocations("file:E:/Tomcat8/webapps");
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/test/**").addResourceLocations("classpath:/test/");
        super.addResourceHandlers(registry);
    }
}
