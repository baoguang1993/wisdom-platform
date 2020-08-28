package com.libaoguang.cn.principlepro.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskExecutorService {
    private static final Logger log= LoggerFactory.getLogger(TaskExecutorService.class);
    @Async("asyncTaskExecutor")
    public void eventExecutor(){
        log.info("TaskExecutorService===eventExecutor===");
        log.info(Thread.currentThread().getName());
    }
}
