package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.UserDetailDto;
import com.qf.ecms.exception.DaoException;
import org.apache.ibatis.annotations.Param;

/**
 * 用户详细信息mapper
 */
public interface UserDetailMapper {

    /**
     * 根据用户id查询用户的详细信息
     *
     * @param userId
     * @return
     */
    UserDetailDto selectUserDetail(@Param("userId") int userId) throws DaoException;


}
