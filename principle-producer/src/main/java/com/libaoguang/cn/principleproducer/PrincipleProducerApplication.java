package com.libaoguang.cn.principleproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.libaoguang.cn.principleproducer","springconfig"})
public class PrincipleProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrincipleProducerApplication.class, args);
    }

}
