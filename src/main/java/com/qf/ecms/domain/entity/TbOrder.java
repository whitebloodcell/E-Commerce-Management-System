package com.qf.ecms.domain.entity;

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
    * 订单状态
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