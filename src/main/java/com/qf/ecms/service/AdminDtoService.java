package com.qf.ecms.service;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDtoService {
    //管理员登录
    AdminDto selectByName(String adminName, String password);

    //显示管理员列表
    List<AdminDto> list(int page,int size);
}
