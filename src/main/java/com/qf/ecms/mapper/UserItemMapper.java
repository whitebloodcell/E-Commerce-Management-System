package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserItem;
import org.apache.ibatis.annotations.Param;

public interface UserItemMapper {
    int deleteByPrimaryKey(Integer userItemId);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    UserItem selectByPrimaryKey(Integer userItemId);

    int updateByPrimaryKeySelective(UserItem record);

    int updateByPrimaryKey(UserItem record);

    /**
     * 根据用户id修改用户详情信息
     * @param userItem
     * @return
     */
    int updateUserItemById(@Param("userItem") UserItem userItem);
}