package com.qf.ecms.domain.entity;

import lombok.Data;

/**
 * 颜色尺寸表
 */
@Data
public class ColorSize {
    /**
     * 颜色尺寸表主键
     */
    private Integer csid;

    /**
     * 颜色名
     */
    private String colorName;

    /**
     * 尺寸名
     */
    private String sizeName;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 商品原价
     */
    private Long originalPrice;

    /**
     * 现价
     */
    private Long presentPrice;

    /**
     * 商品id
     */
    private Integer cid;
}