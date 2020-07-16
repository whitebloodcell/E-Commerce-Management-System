package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Jurisdiction;

public interface JurisdictionMapper {
    int deleteByPrimaryKey(Integer jurisdictionId);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer jurisdictionId);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
}