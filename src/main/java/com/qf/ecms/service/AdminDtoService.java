package com.qf.ecms.service;

import com.qf.ecms.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDtoService {
    //管理员登录
    Admin selectByName(String adminName,String password);
}
