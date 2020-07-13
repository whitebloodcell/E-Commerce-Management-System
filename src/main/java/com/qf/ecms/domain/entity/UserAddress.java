package com.qf.ecms.domain.entity;

import lombok.Data;

/**
    * 用户地址表
    */
@Data
public class UserAddress {
    /**
    * 用户地址表主键
    */
    private Integer addressId;

    /**
    * 收货人姓名
    */
    private String name;

    /**
    * 省名
    */
    private String province;

    /**
    * 市名
    */
    private String city;

    /**
    * 地区/县名
    */
    private String district;

    /**
    * 街道名
    */
    private String street;

    /**
    * 详细地址
    */
    private String addressDetail;

    /**
    * 收货人手机号
    */
    private String phone;

    /**
    * 是否是默认地址,0不是默认,1是默认
    */
    private Integer isDefault;

    /**
    * 是否删除,0是未删除,1是删除
    */
    private Integer isDel;

    /**
    * 用户表id
    */
    private Integer userId;
}