package com.qf.ecms.domain.entity;

import lombok.Data;

/**
    * 商品详情表
    */
@Data
public class Commodity {
    /**
    * 商品表主键
    */
    private Integer cid;

    /**
    * 商品标题
    */
    private String commodityTitle;

    /**
    * 二级分类id
    */
    private Integer ssid;

    /**
    * 一级分类id
    */
    private Integer psid;

    /**
    * 是否是新品,1是新品,0不是新品
    */
    private Integer isNew;

    /**
    * 是否启用,1是启用,0是禁用,2是逻辑删除
    */
    private Integer enable;

    /**
    * 商品封面图
    */
    private String commodityPicture;
}