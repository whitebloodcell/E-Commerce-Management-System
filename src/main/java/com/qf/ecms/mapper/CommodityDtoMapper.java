package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.CommodityDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CommodityDtoMapper {


    //这是搜索,需要模糊查询,所有cid和title是传入同一个数据,还有时间点(time),还有分页
    List<CommodityDto> selectAll(@Param("cidOrTitle") int cid, @Param("cidOrTitle") String title, @Param("time") Date time, @Param("limit") int limit, @Param("offset") int offset);


    //
//    int update(@Param("commodityDto") CommodityDto commodityDto);
}
