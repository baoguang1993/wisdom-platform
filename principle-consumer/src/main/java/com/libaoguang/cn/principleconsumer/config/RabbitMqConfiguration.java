package com.libaoguang.cn.principleconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitMqConfiguration {
   @Value("${myqueue.queuename}")
   private String TOKEN_QUEUE;

    @Bean
    public Queue miaoShaQueue(){
        return new Queue(TOKEN_QUEUE,true);
    }
}
