package com.libaoguang.cn.principlepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.libaoguang.cn.principlepro","springconfig","com.libaoguang.cn.principledao"})
public class PrincipleProApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrincipleProApplication.class, args);
    }

}
