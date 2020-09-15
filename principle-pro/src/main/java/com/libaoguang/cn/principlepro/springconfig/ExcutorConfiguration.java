package com.libaoguang.cn.principlepro.springconfig;


import com.libaoguang.cn.principlepro.service.TaskService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@EnableAsync
@Configuration
public class ExcutorConfiguration {

private static final Logger log= LoggerFactory.getLogger(ExcutorConfiguration.class);
    /**
     * 核心线程数
     */
   // @Value("${async.excutor.thread.core_pool_zise}")
    private int corePoolSize=10;

    /**
     * 最大线程数
     */
   // @Value("${async.excutor.thread.max_pool_zise}")
    private int maxPoolSize=10;

    /**
     * 队列大小
     */
   // @Value("${async.excutor.thread.queue_capacity}")
    private int queueCapacity=10;
    /**
     * 线程前缀名
     */
  //  @Value("${async.excutor.thread.name.prefix}")
    private String namePrefix="ss";

    @Bean(initMethod = "executorInit")
    public TaskService taskService(){
        log.info("ExcutorConfiguration{}-->initbean TaskService");
        return new TaskService();
    }

    /**
     * 初始化线程池
     * @return
     */
    @Bean("asyncTaskExecutor")
    public Executor asyncServiceExecutor(){
        log.info("初始化线程池{}-->init asyncServiceExecutor");
        ThreadPoolTaskExecutor executor=new CustomThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    public static final class CustomThreadPoolTaskExecutor extends ThreadPoolTaskExecutor{
      private void showThreadInfo(String prefix){
          ThreadPoolExecutor   threadPoolExecutor=getThreadPoolExecutor();
          if(null!=threadPoolExecutor){
              return;
          }
          log.info(
                  "{} TaskCount;{} CompletedTaskCount; {}ActiveCount;{}Queue size",
                  this.getThreadNamePrefix(),
                  prefix,
                  threadPoolExecutor.getTaskCount(),
                  threadPoolExecutor.getCompletedTaskCount(),
                  threadPoolExecutor.getActiveCount(),
                  threadPoolExecutor.getQueue().size()
          );

      }
        @Override
        public void execute(Runnable task) {
          showThreadInfo("1. do execute");
            super.execute(task);

        }

        @Override
        public void execute(Runnable task, long startTimeout) {
            showThreadInfo("2. do execute");
            super.execute(task, startTimeout);
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            showThreadInfo("1. do submit");
            return super.submit(task);
        }

        @Override
        public Future<?> submit(Runnable task) {
            showThreadInfo("2. do submit");
            return super.submit(task);
        }

        @Override
        public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
            showThreadInfo("1. do submitListenable");
            return super.submitListenable(task);
        }

        @Override
        public ListenableFuture<?> submitListenable(Runnable task) {
            showThreadInfo("2. do submitListenable");
            return super.submitListenable(task);
        }

    }
}
