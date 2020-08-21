package com.libaoguang.cn.principleconsumer.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "token-queue")
public class MessageConsumer {
    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);


    @RabbitHandler
    public void recieved(String msg) {
        //从缓存中读取token
        String token="";
        logger.info("[tokenQueue] recieved message: " + msg);
    }
}
