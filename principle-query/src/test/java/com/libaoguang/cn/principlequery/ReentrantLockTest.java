package com.libaoguang.cn.principlequery;

import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PrincipleQueryApplication.class)
public class ReentrantLockTest {

//
//    public static void main(String[] args) {
//        String SS = "91310115MA1K3J0A7C";
//        boolean b = checkCreditCode(SS);
//        System.out.println("b:" + b);
//    }

    public static boolean checkCreditCode(String str) {
        boolean check = true;
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            Integer length = str.length();
            if (18 != length) {
                return false;
            } else {
                char[] code = str.toCharArray();
                for (int i = 0; i < 17; i++) {
                    Character key = code[i];
                    if (code[i] >= 'A' && code[i] <= 'Z') {
                    } else if (code[i] >= '0' && code[i] <= '9') {
                    } else {
                        check = false;
                    }
                }
            }
        }
        return check;

    }
    public static void main(String[] args) throws Exception {
        TestUser user1=new TestUser();
        user1.setAge(20);

        TestUser user2=new TestUser();
        user2.setAge(21);

        TestUser user3=new TestUser();
        user3.setAge(22);

        List userlist1=new ArrayList();
        userlist1.add(user1);
        userlist1.add(user2);
        userlist1.add(user3);

        List userlist2=new ArrayList();
        userlist2.add(user3);

        boolean containsAll = userlist1.containsAll(userlist2);
        System.out.println("containsAll==="+containsAll);

    }


}
