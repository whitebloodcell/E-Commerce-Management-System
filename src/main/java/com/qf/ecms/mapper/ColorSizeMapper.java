package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorSize;

public interface ColorSizeMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(ColorSize record);

    int insertSelective(ColorSize record);

    ColorSize selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(ColorSize record);

    int updateByPrimaryKey(ColorSize record);
}