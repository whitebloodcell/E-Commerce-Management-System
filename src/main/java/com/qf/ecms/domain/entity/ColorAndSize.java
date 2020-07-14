package com.qf.ecms.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ColorAndSize {
    private Integer csid;
    private String colorName;
    private String sizeName;
    private Integer stock;
    private BigDecimal originalPrice;  //商品价格
    private BigDecimal presentPrice;    //现价
    private Integer cid;

}
