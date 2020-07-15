package com.qf.ecms.mapper;


import com.qf.ecms.domain.entity.Commodity;

import org.apache.ibatis.annotations.Param;


public interface CommodityMapper {


    int insert(@Param("commodity") Commodity commodity);


}
