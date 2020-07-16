package com.qf.ecms.domain.dto;


import lombok.Data;

@Data
public class MenuDto {
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

    private JurisdictionDto jurisdictionDto;

}
