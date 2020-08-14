package com.libaoguang.cn.principlepro.manager;

import com.libaoguang.cn.principledao.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
    @Autowired
    private UserDao userDao;
}
