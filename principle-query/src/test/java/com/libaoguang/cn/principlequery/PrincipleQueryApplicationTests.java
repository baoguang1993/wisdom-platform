package com.libaoguang.cn.principlequery;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrincipleQueryApplication.class)
public class PrincipleQueryApplicationTests {
    @Autowired
    private TransportClient client;

   @Test
    public void add()throws Exception{
       XContentBuilder contentBuilder= XContentFactory.jsonBuilder()
               .startObject()
               .field("title","qqq")
               .field("author","111")
               .endObject();
       IndexResponse indexResponse = this.client.prepareIndex("book", "novel")
               .setSource(contentBuilder).get();
       String id = indexResponse.getId();
       System.out.println("id"+id);

   }
}
