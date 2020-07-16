package com.qf.ecms.domain.dto;


import com.qf.ecms.domain.entity.ColorSize;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.domain.entity.CommodityPicture;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class CommodityDto {
    private Commodity commodity;
    private CommodityDetail commodityDetail;
    private ColorSize colorSize;
    private CommodityPicture commodityPicture;



    private String keyword;
    private String time;
    private Integer limit;
    private Integer offset;

    //搜索商品时需要的字段返回
//    private Integer stock;
//    private BigDecimal originalPrice;
//    private BigDecimal presentPrice;
//    private Integer cid;
//    private String commodityTitle;
//    private Integer enable;
//    private Date createTime;
}
