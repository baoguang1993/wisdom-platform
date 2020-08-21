package com.libaoguang.cn.principleconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitMqConfiguration {
    public static final String TOKEN_QUEUE = "token-queue";

    @Bean
    public Queue miaoShaQueue(){
        return new Queue(TOKEN_QUEUE,true);
    }
}
