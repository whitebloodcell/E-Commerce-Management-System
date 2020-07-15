package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.User;
import org.apache.ibatis.annotations.Param;

public interface ReceptionUserMapper {

    User selectByUserAccount(@Param("userAccount") String userAccount);

    int insertUser(@Param("user") User user);
}