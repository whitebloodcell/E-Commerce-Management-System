package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.UserDetailDto;
import org.apache.ibatis.annotations.Param;

public interface UserDetailMapper {

    /**
     * 根据用户id查询用户的详细信息
     *
     * @param userId
     * @return
     */
    UserDetailDto selectUserDetail(@Param("userId") int userId);
}
