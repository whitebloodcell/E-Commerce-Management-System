package com.qf.ecms.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Integer orderItemId;
    private Integer orderId;
    private Integer userId;
    private String commodityPic;
    private String commodityName;
    private BigDecimal commodityPrice;
    private Integer commodityQuantity;
    private Integer status;

}
