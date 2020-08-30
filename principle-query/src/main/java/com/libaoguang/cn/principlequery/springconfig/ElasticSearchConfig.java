package com.libaoguang.cn.principlequery.springconfig;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticSearchConfig {
    @Bean
    public TransportClient transportClient()throws UnknownHostException {
        InetSocketTransportAddress inetSocketTransportAddress=new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),9300
        );
        Settings esSetting = Settings.builder()
                    .put("cluster.name","elasticsearch")
                    .build();
        TransportClient transportClient=new PreBuiltTransportClient(esSetting);
        transportClient.addTransportAddresses(inetSocketTransportAddress);
        return transportClient;
    }
}
