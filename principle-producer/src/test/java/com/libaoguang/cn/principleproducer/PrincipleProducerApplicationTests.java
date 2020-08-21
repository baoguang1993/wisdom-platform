package com.libaoguang.cn.principleproducer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(classes = PrincipleProducerApplication.class)
class PrincipleProducerApplicationTests {

    @Test
   public void contextLoads() {
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(new Date());
        System.out.println("[demoQueue] send msg: " + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("token-queue", dateString);

        boolean matches = dateString.matches("/str");
      //  str9.matches("//d+");
    }

    @Autowired
    private AmqpTemplate rabbitTemplate;


}
