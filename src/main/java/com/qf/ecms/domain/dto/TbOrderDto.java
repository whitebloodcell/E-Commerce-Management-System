package com.qf.ecms.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TbOrderDto {
    private String orderNo;
    private BigDecimal total;
    private Date createDate;
    private Integer status;
    private String commodityTitle;
    private Integer commodityQuantity;
    private String sortName;
}
