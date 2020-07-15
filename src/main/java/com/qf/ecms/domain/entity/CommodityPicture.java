package com.qf.ecms.domain.entity;

import lombok.Data;

/**
    * 商品图片表
    */
@Data
public class CommodityPicture {
    /**
    * 商品图片表id
    */
    private Integer pid;

    /**
    * 图片地址
    */
    private String pictureUrl;

    /**
    * 商品表主键
    */
    private Integer cid;
}