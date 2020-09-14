package com.libaoguang.cn.principleapollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfig {

    @Value("${redis.port}")
    private String port;

    @RequestMapping("/test")
    public String getPort(){
        return port;
    }
}
