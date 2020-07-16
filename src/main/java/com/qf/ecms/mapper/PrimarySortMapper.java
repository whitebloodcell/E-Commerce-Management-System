package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.PrimarySort;

public interface PrimarySortMapper {
    int deleteByPrimaryKey(Integer psid);

    int insert(PrimarySort record);

    int insertSelective(PrimarySort record);

    PrimarySort selectByPrimaryKey(Integer psid);

    int updateByPrimaryKeySelective(PrimarySort record);

    int updateByPrimaryKey(PrimarySort record);
}