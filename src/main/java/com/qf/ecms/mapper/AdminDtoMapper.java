package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDtoMapper {
    //管理员登录
    Admin selectByName(@Param("adminName") String adminName);

    //管理员列表
    List<Admin> list(@Param("limit") int limit, @Param("size") int size);

    //查询管理员
    List<Admin> selectByNameOrTime(@Param("adminName") String adminName,@Param("createTime") String createTime,@Param("limit") int limit,@Param("size") int size);
}
