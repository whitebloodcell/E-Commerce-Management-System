package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserItem;

public interface UserItemMapper {
    int deleteByPrimaryKey(Integer userItemId);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    UserItem selectByPrimaryKey(Integer userItemId);

    int updateByPrimaryKeySelective(UserItem record);

    int updateByPrimaryKey(UserItem record);
}