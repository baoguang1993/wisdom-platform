package com.libaoguang.cn.principlepro.service.impl;

import com.libaoguang.cn.principlejpa.entity.BasisUser;
import com.libaoguang.cn.principlepro.manager.UserManager;
import com.libaoguang.cn.principlepro.service.Interface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;
    @Override
   public List<BasisUser> listUser(){
        List<BasisUser> basisUsers = userManager.listUser();
        return basisUsers;
    }
}
