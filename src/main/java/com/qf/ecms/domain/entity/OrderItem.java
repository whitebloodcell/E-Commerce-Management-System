package com.qf.ecms.domain.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem {
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
    private Integer userId;

    /**
     * 商品图片
     */
    private String commodityPic;

    /**
     * 商品名称
     */
    private String commodityTitle;

    /**
     * 商品价格
     */
    private BigDecimal commodityPrice;

    /**
     * 购买数量
     */
    private Integer commodityQuantity;

    /**
     * 状态,0是启用,1是删除
     */
    private Integer status;

    /**
     * 颜色
     */
    private String colorName;

    /**
     * 尺码
     */
    private String sizeName;

    /**
     * 商品id
     */
    private Integer cid;
}