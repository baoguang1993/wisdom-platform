package com.libaoguang.cn.principlequery.springconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProerties {
//    private String ips;
//    private int timeout;
//
//    public String getIps() {
//        return ips;
//    }
//
//
//    public void setIps(String ips) {
//        this.ips = ips;
//    }
//
//
//    public int getTimeout() {
//        return timeout;
//    }
//
//
//    public void setTimeout(int timeout) {
//        this.timeout = timeout;
//    }


}
