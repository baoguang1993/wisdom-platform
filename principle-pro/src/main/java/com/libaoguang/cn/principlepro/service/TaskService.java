package com.libaoguang.cn.principlepro.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class TaskService {
    @Autowired
    TaskExecutorService taskExecutorService;
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    public void executorInit() {
        log.warn("TaskService {} executorInit");
        taskExecutorService.eventExecutor();

//        for (; ; ) {
//            //查询队列，执行业务逻辑方法
//            taskExecutorService.eventExecutor();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }


    }
}
