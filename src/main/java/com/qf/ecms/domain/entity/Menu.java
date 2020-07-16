package com.qf.ecms.domain.entity;

import lombok.Data;

@Data
public class Menu {
    /**
    * 菜单id
    */
    private Integer menuId;

    /**
    * 菜单名
    */
    private String menuName;

    /**
    * 角色表id
    */
    private Integer roleId;
}