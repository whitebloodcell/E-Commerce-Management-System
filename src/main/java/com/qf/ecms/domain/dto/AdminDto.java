package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.AdminDetail;
import lombok.Data;

import java.util.Date;


@Data
public class AdminDto {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员用户名
     */
    private String adminName;

    /**
     * 管理员用户密码
     */
    private String adminPassword;

    /**
     * 角色id,关联角色表
     */
    private Integer roleId;

    /**
     * 状态码: 0是冻结      1是正常
     */
    private Integer adminStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    private AdminDetail adminDetail;

    private RoleDto roleDto;
}
