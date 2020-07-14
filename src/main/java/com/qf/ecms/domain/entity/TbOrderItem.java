package com.qf.ecms.domain.entity;

import lombok.Data;

@Data
public class TbOrderItem {
    /**
    * 主键
    */
    private Integer orderItemId;

    /**
    * 订单号
    */
    private Integer orderId;

    /**
    * 会员id
    */
    private Long memberId;

    /**
    * 商品图片
    */
    private String productPic;

    /**
    * 商品名称
    */
    private String productName;

    /**
    * 商品价格
    */
    private String productPrice;

    /**
    * 购买数量
    */
    private String productQuantity;

    /**
    * 状态
    */
    private Integer status;
}