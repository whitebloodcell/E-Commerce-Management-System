package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserItem;
import org.apache.ibatis.annotations.Param;

public interface UserItemMapper {
    UserItem selectByUserId(@Param("userId") int userId);
}