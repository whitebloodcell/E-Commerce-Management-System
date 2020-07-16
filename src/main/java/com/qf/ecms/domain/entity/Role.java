package com.qf.ecms.domain.entity;

import lombok.Data;

@Data
public class Role {
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;
}