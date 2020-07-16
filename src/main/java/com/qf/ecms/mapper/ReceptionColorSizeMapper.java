package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorSize;
import org.apache.ibatis.annotations.Param;

public interface ReceptionColorSizeMapper {

    int updateToStock(@Param("csid") int csid,@Param("stock") int stock ,@Param("version") int version);

    ColorSize selectByCsId(@Param("csid") int csid);

}