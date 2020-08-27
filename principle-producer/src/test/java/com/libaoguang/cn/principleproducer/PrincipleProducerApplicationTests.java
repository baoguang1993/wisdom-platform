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
        // 第一个参数为刚刚定义的队列名称
        int i=0;
        while (true){
            this.rabbitTemplate.convertAndSend("message.queue", dateString+"---"+i);
            System.out.println("queue"+dateString+"---"+i);
            ++i;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
//        for(;;){
//
//        }


    }

    @Autowired
    private AmqpTemplate rabbitTemplate;


}
