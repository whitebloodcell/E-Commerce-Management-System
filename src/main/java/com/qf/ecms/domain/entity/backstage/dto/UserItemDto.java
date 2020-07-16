package com.qf.ecms.domain.entity.backstage.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserItemDto {
    /**
     * 用户详情id
     */
    private Integer userItemId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userItemNickname;

    /**
     * 手机号
     */
    private String userItemPhone;

    /**
     * 邮箱
     */
    private String userItemEmail;

    /**
     * 头像
     */
    private String userItemIcon;

    /**
     * 信息更新时间
     */
    private Date updateTime;
}
