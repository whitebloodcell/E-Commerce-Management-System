package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.RoleDto;
import org.apache.ibatis.annotations.Param;

public interface RoleDtoMapper {
    //添加角色（权限名称）
    int insert(@Param("roleDto") RoleDto roleDto);
}
