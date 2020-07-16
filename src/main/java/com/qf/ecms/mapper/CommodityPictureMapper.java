package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityPicture;
import org.apache.ibatis.annotations.Param;

public interface CommodityPictureMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(CommodityPicture record);

    int insertSelective(CommodityPicture record);

    CommodityPicture selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(CommodityPicture record);

    int updateByPrimaryKey(CommodityPicture record);

    int insertAllCommodity(@Param("commodityPicture") CommodityPicture commodityPicture);
}