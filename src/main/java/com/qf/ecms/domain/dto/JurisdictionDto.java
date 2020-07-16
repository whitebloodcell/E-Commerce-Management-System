package com.qf.ecms.domain.dto;

import lombok.Data;

@Data
public class JurisdictionDto {
    /**
     * 权限id
     */
    private Integer jurisdictionId;

    /**
     * 管理内容名称
     */
    private String jurisdictionName;

    /**
     * 菜单表id
     */
    private Integer menuId;

    /**
     * 1表示添加，2表示删除，4表示修改，8表示查询,3表示添加和删除，5表示添加和修改，6表示删除和修改，7表示添加、删除和修改，9表示添加和查询，10表示删除和查询，11表示添加、删除和查询，12表示修改和查询，13表示添加、修改和查询，14表示删除、修改和查询，15表示添加、删除、修改和查询，16表示审核
     */
    private Integer opcode;
}
