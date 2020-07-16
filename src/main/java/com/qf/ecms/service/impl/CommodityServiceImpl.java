package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.ColorSizeMapper;
import com.qf.ecms.mapper.CommodityDetailMapper;
import com.qf.ecms.mapper.CommodityMapper;
import com.qf.ecms.mapper.CommodityPictureMapper;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;
    @Resource
    CommodityDetailMapper commodityDetailMapper;
    @Resource
    ColorSizeMapper colorSizeMapper;
    @Resource
    CommodityPictureMapper commodityPictureMapper;


    @Override
    @Transactional
    public int add(CommodityDto commodityDto)  {

        int add = commodityMapper.insertAllCommodity(commodityDto.getCommodity());
        if (add == 0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        Integer cid = commodityDto.getCommodity().getCid();
        //先创建commodity的数据,才有Cid,下面的数据添加需要cid
        commodityDto.getCommodityDetail().setCid(cid);
        commodityDto.getColorSize().setCid(cid);
        commodityDto.getCommodityPicture().setCid(cid);

        int addDetail = commodityDetailMapper.insertAllCommodity(commodityDto.getCommodityDetail());
        if (addDetail == 0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        int addPicture = commodityPictureMapper.insertAllCommodity(commodityDto.getCommodityPicture());
        if (addPicture == 0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        int addColor = colorSizeMapper.insertAllCommodity(commodityDto.getColorSize());
        if (addColor == 0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }


        return addColor;
    }


}
