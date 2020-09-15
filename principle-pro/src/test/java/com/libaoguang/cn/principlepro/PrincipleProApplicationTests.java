package com.libaoguang.cn.principlepro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.libaoguang.cn.principlecommon.enums.Pc;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class PrincipleProApplicationTests {

    public static void main(String[] args) {
        Map param=new HashMap();
        param.put("name","libaoguang");

        List<Map> requestParam=new ArrayList<>();
        Map map1=new HashMap();
        map1.put("age",11);

        Map map2=new HashMap();
        map2.put("age",12);

        Map map3=new HashMap();
        map3.put("age",13);
        requestParam=Arrays.asList(map1,map2,map3);
        param.put("requestParam",requestParam);

        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(param);
        Object requestParam2 = jsonObject.get("requestParam");
        Map map=new HashMap();
        map.put("requestParam",requestParam2);
        JSONObject json = (JSONObject)JSONObject.toJSON(map);
        String s = json.toJSONString();
        JSONObject applyDetailList = JSONObject.parseObject(s);
        System.out.println(applyDetailList);


    }
    public static void add(String key,String...values){
        for(String str:values){
            System.out.println(str);
        }

    }
}
