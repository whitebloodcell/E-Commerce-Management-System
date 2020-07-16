package com.qf.ecms.service;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.dto.RoleDto;
import com.qf.ecms.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDtoService {
    //管理员登录
    AdminDto selectByName(String adminName, String password);

    //显示管理员列表
    List<AdminDto> list(int page,int size);

    //查询管理员
    List<AdminDto> selectByNameOrTime(String adminName,String createTime,int limit,int size);

    //添加管理员
    int insert(RoleDto roleDto);
}
