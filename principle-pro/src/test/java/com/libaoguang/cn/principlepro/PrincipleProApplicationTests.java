package com.libaoguang.cn.principlepro;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.HtmlUtils;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@SpringBootTest
class PrincipleProApplicationTests {

    public static void main(String[] args) {
        for(int i=0;i<6;++i){
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        }

    }
    public static void add(String key,String...values){
        for(String str:values){
            System.out.println(str);
        }

    }
}
