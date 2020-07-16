package com.qf.ecms.domain.entity;

import java.util.Date;
import lombok.Data;

/**
 * 商品详细信息表
 */
@Data
public class CommodityDetail {
    /**
     * 商品详情表主键
     */
    private Integer cdid;

    /**
     * 详细内容
     */
    private String detailsContent;

    /**
     * 商品型号
     */
    private String model;

    /**
     * 商品毛重
     */
    private Double weight;

    /**
     * 上架时间
     */
    private Date createTime;

    /**
     * 商品表主键
     */
    private Integer cid;
}