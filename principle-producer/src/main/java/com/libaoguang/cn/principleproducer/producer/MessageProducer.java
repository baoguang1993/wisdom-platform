package com.libaoguang.cn.principleproducer.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDemoQueue() {
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(new Date());
        System.out.println("[demoQueue] send msg: " + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("message-queue", dateString);
    }
}
