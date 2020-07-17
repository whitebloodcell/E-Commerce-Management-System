package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Commodity;import org.apache.ibatis.annotations.Param;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);

    int insertAllCommodity(@Param("commodity") Commodity commodity);
}