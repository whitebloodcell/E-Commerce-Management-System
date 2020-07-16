package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.domain.entity.CommodityPicture;
import org.apache.ibatis.annotations.Param;

public interface CommodityPictureMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(CommodityPicture record);

    int insertSelective(CommodityPicture record);

    CommodityPicture selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(CommodityPicture record);

    int updateByPrimaryKey(CommodityPicture record);



    //添加商品到4个表中的一个
    int insertAllCommodity(@Param("commodityPicture") CommodityPicture commodityPicture);
    //在任意一个表中修改任意的商品信息
    int updateCommodityPicture(@Param("commodityPicture") CommodityPicture commodityPicture);
}