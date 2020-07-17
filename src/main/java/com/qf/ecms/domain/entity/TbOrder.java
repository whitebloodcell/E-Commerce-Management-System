package com.qf.ecms.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class TbOrder {
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
    private BigDecimal total;

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 逻辑删除,0是启用,1是删除
    */
    private Integer isDel;

    /**
    * 地址id
    */
    private Integer userAddressId;
}