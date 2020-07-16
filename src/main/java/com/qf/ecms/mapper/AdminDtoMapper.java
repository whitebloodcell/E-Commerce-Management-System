package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDtoMapper {
    //管理员登录
    AdminDto selectByName(@Param("adminName") String adminName);

    //显示管理员列表
    List<AdminDto> list(@Param("limit") int limit, @Param("size") int size);

    //查询管理员
    List<AdminDto> selectByNameOrTime(@Param("adminName") String adminName,@Param("createTime") String createTime,@Param("limit") int limit,@Param("size") int size);
}
