package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.backstage.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDtoMapper {
    //分页显示所有会员信息
    List<User> list(@Param("limit") int limit, @Param("size") int size);

    //根据用户名或者创建时间查询会员信息
    List<User> selectByNameOrTime(@Param("userItemNickname") String userItemNickname,@Param("createTime") String  createTime,@Param("limit") int limit,@Param("size") int size);

    //删除用户
    int delete(@Param("userId") int userId);

    //批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    //启用用户
    int active(@Param("userId") int userId);

    //添加用户
    int insert(@Param("userDto") UserDto userDto);

    //修改用户信息
    int updateByPrimaryKeySelective(@Param("userDto") UserDto userDto);

}
