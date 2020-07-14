package com.qf.ecms.service.impl;


import com.qf.ecms.domain.entity.Commodity;

import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.CommodityMapper;
import com.qf.ecms.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    @Override
    public int add(Commodity commodity) throws ServiceException {

        int row = commodityMapper.insert(commodity);
        if (row == 0){
            throw new ServiceException("commodity商品表添加失败!",40001);
        }



        return row;
    }
}
