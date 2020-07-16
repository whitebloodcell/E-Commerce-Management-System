package com.qf.ecms.domain.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ShopCart {
    /**
     * 购物车id
     */
    private Integer cartId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 购买的商品数量
     */
    private Integer count;

    /**
     * 商品id
     */
    private Integer cid;

    /**
     * 商品标题
     */
    private String commodityTitle;

    /**
     * 商品封面图
     */
    private String commodityPicture;

    /**
     * 颜色名
     */
    private String colorName;

    /**
     * 尺寸名
     */
    private String sizeName;

    /**
     * 颜色尺寸表主键
     */
    private Integer csid;

    /**
     * 现价
     */
    private BigDecimal presentPrice;

    /**
     * 状态码 1:正常 0:删除
     */
    private Integer status;
}