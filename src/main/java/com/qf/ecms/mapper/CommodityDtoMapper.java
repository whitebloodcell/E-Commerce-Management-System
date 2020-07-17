package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.CommodityDto;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CommodityDtoMapper {


    //这是搜索,需要模糊查询,所有cid和title是传入同一个数据,还有时间点(time),还有分页
    List<CommodityDto> selectAllCommodityDto(@Param("commodityDto") CommodityDto commodityDto);


}
