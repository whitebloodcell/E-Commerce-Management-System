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

    //添加管理员
    int insert(@Param("adminDto") AdminDto adminDto);

    //修改管理员信息
    int update(@Param("adminDto") AdminDto adminDto);

    //删除管理员
    int delete(@Param("adminId") int adminId);

    //批量删除管理员
    int deleteBatch(@Param("adminIds") List<Integer> adminIds);

    //激活管理员
    int active(@Param("adminId") int adminId);
}
