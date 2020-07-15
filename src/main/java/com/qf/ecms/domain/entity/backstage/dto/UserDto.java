package com.qf.ecms.domain.entity.backstage.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户账号
     */
    private String userAccount;

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

    private UserItemDto userItemDto;
}
