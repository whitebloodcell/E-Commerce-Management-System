package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.SecondarySort;

public interface SecondarySortMapper {
    int deleteByPrimaryKey(Integer ssid);

    int insert(SecondarySort record);

    int insertSelective(SecondarySort record);

    SecondarySort selectByPrimaryKey(Integer ssid);

    int updateByPrimaryKeySelective(SecondarySort record);

    int updateByPrimaryKey(SecondarySort record);
}