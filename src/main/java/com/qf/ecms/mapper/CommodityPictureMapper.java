package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityPicture;
import org.apache.ibatis.annotations.Param;

public interface CommodityPictureMapper {
    int insert(@Param("commodityPicture") CommodityPicture commodityPicture);
}