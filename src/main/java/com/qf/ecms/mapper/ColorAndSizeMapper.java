package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorAndSize;
import org.apache.ibatis.annotations.Param;

public interface ColorAndSizeMapper {

    int insert(@Param("colorAndSize") ColorAndSize colorAndSize);

}
