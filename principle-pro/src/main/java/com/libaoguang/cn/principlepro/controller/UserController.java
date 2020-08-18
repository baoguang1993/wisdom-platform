package com.libaoguang.cn.principlepro.controller;


import com.libaoguang.cn.principlecommon.vo.ResultVo;
import com.libaoguang.cn.principledao.entity.BasisUser;
import com.libaoguang.cn.principlepro.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResultVo test() {
        List<BasisUser> basisUsers = userService.listUser();
        System.out.println(basisUsers);
        ResultVo resultVo=ResultVo.successResult();
        return resultVo;
    }
}
