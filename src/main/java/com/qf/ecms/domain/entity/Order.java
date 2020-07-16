package com.qf.ecms.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
    /**
     * 主键
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 订单状态,0代付款,1代发货,2待收货,3已收货,4退款
     */
    private Integer status;

    /**
     * 总价
     */
    private Long total;

    /**
     * 会员ID
     */
    private Integer userId;
}