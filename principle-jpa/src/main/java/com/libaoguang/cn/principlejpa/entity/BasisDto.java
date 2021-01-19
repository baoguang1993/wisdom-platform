package com.libaoguang.cn.principlejpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class BasisDto implements Serializable {

    private Integer id;


    private String userAddress;


    private String userName;



    private int age;


    private int deptGuid;

    private String deptName;


    private Date createTime;


    private Date updateTime;
}
