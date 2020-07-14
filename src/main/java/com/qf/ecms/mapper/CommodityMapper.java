package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorAndSize;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.domain.entity.CommodityDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {



    int insert(@Param("commodity") Commodity commodity);




}
