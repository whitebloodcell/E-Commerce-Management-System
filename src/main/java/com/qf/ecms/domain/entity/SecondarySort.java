package com.qf.ecms.domain.entity;

import lombok.Data;

@Data
public class SecondarySort {
    /**
    * 二级分类主键
    */
    private Integer ssid;

    /**
    * 分类名
    */
    private String sortName;

    /**
    * 是否禁用,0是启用,1是禁用
    */
    private Integer isDisable;

    /**
    * 是否删除,0是未删除,1是删除
    */
    private Integer isDel;

    /**
    * 一级分类主键
    */
    private Integer psid;
}