package com.qf.ecms.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class Order {
    private Integer orderId;
    private String orderNo;
    private Date createDate;
    private Integer status;
    private BigDecimal total;
    private Integer userId;
    private Integer isDel;
}
