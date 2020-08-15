package com.libaoguang.cn.principlecache.springconfig;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RedissonConfiguration {
    private Logger logger= LoggerFactory.getLogger(RedissonConfiguration.class);
   @Bean
    public RedissonClient redissonClient(){
        Config config=new Config();
        config.useClusterServers()
                .setScanInterval(200000)
                .setTimeout(30000)
                .setRetryInterval(30000)
                .addNodeAddress("redis://10.130.33.235:6379","redis://10.130.33.235:6379","redis://10.130.33.235:6379","redis://10.130.33.235:6379");
        RedissonClient redissonClient= Redisson.create(config);
        logger.info("redisson start {} :",!redissonClient.isShutdown());
        return redissonClient;
    }
}
