package com.libaoguang.cn.principleapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class PrincipleApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrincipleApolloApplication.class, args);
    }

}
