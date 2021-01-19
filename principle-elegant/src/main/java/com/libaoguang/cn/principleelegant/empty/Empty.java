package com.libaoguang.cn.principleelegant.empty;

import com.libaoguang.cn.principleelegant.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Slf4j
public class Empty {
    public static final Logger logger= LoggerFactory.getLogger(Empty.class);

    public static void main(String[] args) {
        User user=new User();
        Optional.ofNullable(user.getUserName());

    }
    public static User createUser(String address){
        User user=new User();
        user.setAddress(address);
        logger.info(address);
        return user;
    }
    public void test01(){
        User user=null;
        //  user=createUser("wangwu");
        /**
         * 当user值不为null时，orElse函数依然会执行createUser()方法，只是不改变值,而orElseGet函数并不会执行createUser()方法
         */
        user= Optional.ofNullable(user).orElse(createUser("lisi"));
        // user = Optional.ofNullable(user).orElseGet(() -> createUser("zhangsan"));
        //获取一个变量的值
        String address=null;

        Optional.ofNullable(user)
                .ifPresent(u->{
                    u.setAddress("zhaoliu");
                });
        address=user.getAddress();

        logger.info(address);
    }
}
