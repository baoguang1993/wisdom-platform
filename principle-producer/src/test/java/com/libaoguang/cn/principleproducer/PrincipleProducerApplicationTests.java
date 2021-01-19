package com.libaoguang.cn.principleproducer;


import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = PrincipleProducerApplication.class)
class PrincipleProducerApplicationTests {


    @Test
    public void contextLoads() {
        for(int i=0;i<10;++i){
            String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(new Date());
            System.out.println("[demoQueue] send msg: " + dateString);
            // 第一个参数为刚刚定义的队列名称
            this.rabbitTemplate.convertAndSend("token-queue", dateString);

            System.out.println("dateString==="+dateString);
        }

    }

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public static void main(String[] args) {
        Student student=new Student();
        student.setAge(10);
        List<Student> list=new ArrayList<>();
        list.add(student);

        for (Student studs:list){
            studs.setAge(20);
        }
        System.out.println(list);
    }

}
