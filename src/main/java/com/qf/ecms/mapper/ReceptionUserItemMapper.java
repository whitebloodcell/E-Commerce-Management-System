package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserItem;
import org.apache.ibatis.annotations.Param;

public interface ReceptionUserItemMapper {
    UserItem selectByUserId(@Param("userId") int userId);

    UserItem selectByPhone(@Param("userItemPhone") String userItemPhone);

    UserItem selectByEmail(@Param("userItemEmail") String userItemEmail);

    int insertPhoneAndEmail(@Param("userItem") UserItem userItem);
}