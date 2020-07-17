package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.AdminDetailDto;
import org.apache.ibatis.annotations.Param;

public interface AdminDetailDtoMapper {
    int insert(@Param("adminDetailDto") AdminDetailDto adminDetailDto);

    int update(@Param("adminDetailDto") AdminDetailDto adminDetailDto);
}
