package com.libaoguang.cn.principlejpa.entity;



import lombok.Data;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "basis_user")
public class BasisUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_address",nullable = false)
    private String userAddress;

    @Column(name = "user_name",nullable = false)
    private String userName;


    @Column(name = "user_age",nullable = false)
    private int age;

    @Column(name = "dept_guid",nullable = false)
    private int deptGuid;



    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;
}
