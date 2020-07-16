package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.CommodityDtoMapper;
import com.qf.ecms.service.CommodityDtoService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class CommodityDtoServiceImpl implements CommodityDtoService {
    @Resource
    CommodityDtoMapper commodityDtoMapper;


    //这是搜索,需要模糊查询,所有cid和title是传入同一个数据,还有时间点(time),还有分页
    @Override
    public List<CommodityDto> query(CommodityDto commodityDto) {

        List<CommodityDto> list = commodityDtoMapper.selectAllCommodityDto(commodityDto);

        if (list == null){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        return list;

    }
}
