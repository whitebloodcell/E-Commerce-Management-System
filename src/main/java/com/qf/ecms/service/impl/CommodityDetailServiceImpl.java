package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.CommodityDetailMapper;
import com.qf.ecms.service.CommodityDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CommodityDetailServiceImpl implements CommodityDetailService {
    @Resource
    CommodityDetailMapper commodityDetailMapper;


    @Override
    public int add(CommodityDetail commodityDetail) throws ServiceException {
        int row = commodityDetailMapper.insert(commodityDetail);
        if (row == 0){
            throw new ServiceException("commodityDetail表数据添加失败",40001);
        }


        return row;
    }
}
