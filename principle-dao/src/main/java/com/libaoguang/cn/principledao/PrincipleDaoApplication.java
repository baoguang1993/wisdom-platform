package com.libaoguang.cn.principledao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.libaoguang.cn.principledao.mapper"})
public class PrincipleDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrincipleDaoApplication.class, args);
    }

}
