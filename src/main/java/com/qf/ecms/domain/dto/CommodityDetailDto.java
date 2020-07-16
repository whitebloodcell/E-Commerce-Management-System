package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.ColorSize;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.domain.entity.CommodityPicture;
import lombok.Data;

import java.util.List;

/**
 * 商品详情页Dto
 */
@Data
public class CommodityDetailDto {
    Commodity commodity;
    CommodityDetail commodityDetail;
    List<ColorSize> colorSize;
    List<CommodityPicture> commodityPicture;

    //积累销量
    int salesVolume;
    //评论数量
    int commentsCount;



}
