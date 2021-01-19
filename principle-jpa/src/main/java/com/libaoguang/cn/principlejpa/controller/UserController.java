package com.libaoguang.cn.principlejpa.controller;


import com.libaoguang.cn.principlejpa.entity.BasisDto;
import com.libaoguang.cn.principlejpa.entity.BasisUser;
import com.libaoguang.cn.principlejpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("/list")
    public String listUser(){

        Pageable pageable = PageRequest.of(0, 10);
        String sql="select buser.user_name userName,dept.name deptName from basis_user buser left join basis_dept dept ON buser.dept_guid=dept.id WHERE buser.user_age=:age";
        Page<List<Map<String, Object>>> findall = userRepository.findall(sql,20, pageable);
        int totalPages = findall.getTotalPages();
        logger.info(totalPages+"");
        logger.info(findall.toString());
        return "success";
    }
}
