package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.AdminDetail;

public interface AdminDetailMapper {
    int deleteByPrimaryKey(Integer adminDetailId);

    int insert(AdminDetail record);

    int insertSelective(AdminDetail record);

    AdminDetail selectByPrimaryKey(Integer adminDetailId);

    int updateByPrimaryKeySelective(AdminDetail record);

    int updateByPrimaryKey(AdminDetail record);
}