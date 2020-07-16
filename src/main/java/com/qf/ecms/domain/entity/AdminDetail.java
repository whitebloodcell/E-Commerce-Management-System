package com.qf.ecms.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class AdminDetail {
    /**
    * 管理员详情id
    */
    private Integer adminDetailId;

    /**
    * 管理员id
    */
    private Integer adminId;

    /**
    * 1表示男，2表示女，3表示保密
    */
    private Integer sex;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * QQ号
    */
    private String qq;

    /**
    * 信息更新时间
    */
    private Date updateTime;
}