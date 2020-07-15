package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.UserItem;
import lombok.Data;

import java.util.Date;

@Data
public class UserDetailDto{
    /**
     * 用户账号
     */
    private String userAccount;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户详情id
     */
    private Integer userItemId;


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

}
