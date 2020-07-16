package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.User;import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户id修改密码
     *
     * @param userId
     * @param password
     * @return
     */
    int updatePassword(@Param("userId") int userId, @Param("password") String password);
}