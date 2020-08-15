package com.libaoguang.cn.principlecache.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedissonLock {
    private static final Logger log= LoggerFactory.getLogger(RedissonLock.class);
    @Autowired
    RedissonClient redissonClient;
    public void lock(String key,int expireTime){
        String keyName=key;
        RLock lock = redissonClient.getLock(keyName);
        lock.lock(expireTime, TimeUnit.SECONDS);
        log.info("===lock===>"+Thread.currentThread().getName());
    }
    public void unlock(String key){
        String keyName=key;
        RLock lock = redissonClient.getLock(keyName);
        lock.unlock();
        log.info("===unlock===>"+Thread.currentThread().getName());
    }
}
