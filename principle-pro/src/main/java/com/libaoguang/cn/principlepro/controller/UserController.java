package com.libaoguang.cn.principlepro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.libaoguang.cn.principledao.mapper.UserDao;
import com.libaoguang.cn.principlepro.handler.ExceptionCatch;
import com.libaoguang.cn.principlepro.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/test")
    public ResultVo test() {
        ResultVo resultVo=ResultVo.successResult();
        return resultVo;
    }
}
