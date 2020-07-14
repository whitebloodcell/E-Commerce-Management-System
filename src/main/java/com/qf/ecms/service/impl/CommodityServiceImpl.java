package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.ColorAndSizeMapper;
import com.qf.ecms.mapper.CommodityDetailMapper;
import com.qf.ecms.mapper.CommodityMapper;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;
    @Resource
    CommodityDetailMapper commodityDetailMapper;
    @Resource
    ColorAndSizeMapper colorAndSizeMapper;



    @Override
    public int add(CommodityDto commodityDto) throws ServiceException {

        int insert = commodityMapper.insert(commodityDto.getCommodity());
        if (insert == 0){
            throw new ServiceException(ErrorStatus.DAO_ERROR);
        }

        Integer cid = commodityDto.getCommodity().getCid();
        //先创建commodity的数据,才有Cid,下面的数据添加需要cid
        commodityDto.getCommodityDetail().setCid(cid);
        commodityDto.getColorAndSize().setCid(cid);

        int add = commodityDetailMapper.insert(commodityDto.getCommodityDetail());
        if (add == 0){
            throw new ServiceException(ErrorStatus.DAO_ERROR);
        }


        int row = colorAndSizeMapper.insert(commodityDto.getColorAndSize());
        if (row == 0){
            throw new ServiceException(ErrorStatus.DAO_ERROR);
        }


        return row;
    }
}
