package com.libaoguang.cn.principlepro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan(basePackages = {"com.libaoguang.cn.principlepro","com.libaoguang.cn.principledao"})
@EnableDiscoveryClient
@SpringBootApplication
public class PrincipleProApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrincipleProApplication.class, args);
    }

}
