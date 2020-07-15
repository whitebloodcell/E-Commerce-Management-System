package com.qf.ecms.service;

import com.qf.ecms.domain.entity.User;

import java.util.List;

public interface UserDtoService {
    //分页显示所有会员信息
    List<User> list(int page, int size);

    //根据用户名或者创建时间查询会员信息
    List<User> selectByNameOrTime(String userItemNickname, String  createTime, int page, int size);

    //删除用户
    int delete(int userId);

    //批量删除用户
    int deleteBatch(List<Integer> ids);

    //启用用户
    int active(int userId);

    //添加用户
    int insert(User user);

    //修改用户信息
    int updateByPrimaryKey(User user);


}
