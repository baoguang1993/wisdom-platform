package com.libaoguang.cn.principlepro.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskExecutorService {
    private static final Logger log= LoggerFactory.getLogger(TaskExecutorService.class);

    @Value("${age}")
    private int age;

    @Value("${name}")
    private String name;

    @Async("asyncTaskExecutor")
    public void eventExecutor(){
        log.info("age:"+age);
        log.info("name:"+name);
        log.info("TaskExecutorService===eventExecutor===");
        log.info(Thread.currentThread().getName());
    }
}
