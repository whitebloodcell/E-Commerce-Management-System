package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityDetail;
import org.apache.ibatis.annotations.Param;

public interface CommodityDetailMapper {
    int insert(@Param("commodityDetail") CommodityDetail commodityDetail);
}
