package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.domain.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto {
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

    private List<Menu> menus;

    private List<Admin> admins;
}
