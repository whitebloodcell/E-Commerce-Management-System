package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityDetail;

public interface CommodityDetailMapper {
    int deleteByPrimaryKey(Integer cdid);

    int insert(CommodityDetail record);

    int insertSelective(CommodityDetail record);

    CommodityDetail selectByPrimaryKey(Integer cdid);

    int updateByPrimaryKeySelective(CommodityDetail record);

    int updateByPrimaryKey(CommodityDetail record);
}