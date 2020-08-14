package com.libaoguang.cn.principlepro.service;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TaskService {
    @Autowired
    TaskExecutorService taskExecutorService;
    private static final Logger log= LoggerFactory.getLogger(TaskService.class);
    public void executorInit(){
        log.info("TaskService {} executorInit");
        taskExecutorService.eventExecutor();
//        for(;;){
//
//        }


    }
}
