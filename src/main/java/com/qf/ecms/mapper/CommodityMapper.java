package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Commodity;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}