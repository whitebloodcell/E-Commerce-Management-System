package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.backstage.dto.UserItemDto;
import org.apache.ibatis.annotations.Param;

public interface UserItemDtoMapper {
    int insert(@Param("userItemDto") UserItemDto userItemDto);
}
