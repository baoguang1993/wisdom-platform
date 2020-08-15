package com.libaoguang.cn.principlecache.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Slf4j
@Service
public class JedisLock {
    private Logger logger = LoggerFactory.getLogger(JedisLock.class);
    @Autowired
    JedisCluster jedisCluster;

    public boolean lock(String key, int expireTime) throws Exception {
        long expire = System.currentTimeMillis() + expireTime;
        String expireValue = String.valueOf(expire);
        logger.info(Thread.currentThread().getName() + "thread {}:expireValue :{}" + expireValue);
        Long setnx = jedisCluster.setnx(key, expireValue);
        if (setnx == 1) {
            jedisCluster.expire(key, expireTime);
            return true;
        } else {
            String currentValue = jedisCluster.get(key);
            //锁已过期
            if (currentValue != null && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                String oldValue = jedisCluster.getSet(key, expireValue);
                if (oldValue != null && oldValue.equals(currentValue)) {
                    //考虑并发情况，只有线程的设置和当前时间，他才有权利加锁
                    return true;
                }
            }
        }
        return false;
    }
    public boolean unlock(String key) throws Exception {
        Long del = jedisCluster.del(key);
        if(1==del){
            return true;
        }
        return false;
    }
}
