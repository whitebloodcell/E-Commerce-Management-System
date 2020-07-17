package com.qf.ecms.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 状态码: 0是冻结 1是正常
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户名
     */
    private String userAccount;
}