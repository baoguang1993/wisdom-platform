package com.libaoguang.cn.principlecache.springconfig;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Configuration
public class JedisConfiguration {
    @Autowired
     RedisProerties redisProerties;
    @Bean
    public JedisCluster getJedisCluster(){
        String[] ipArry=redisProerties.getIps().split(",");
        Set<HostAndPort> hostAndPorts=new HashSet<>();
        for(String ipPort:ipArry){
            String[] ipSplit = ipPort.split(":");
            hostAndPorts.add(new HostAndPort(ipSplit[0].trim(),Integer.valueOf(ipSplit[1].trim())));
        }
        return new JedisCluster(hostAndPorts,redisProerties.getTimeout());
    }

}
