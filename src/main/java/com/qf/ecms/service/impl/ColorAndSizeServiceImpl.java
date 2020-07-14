package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.ColorAndSize;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.ColorAndSizeMapper;
import com.qf.ecms.service.ColorAndSizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ColorAndSizeServiceImpl implements ColorAndSizeService {
    @Resource
    ColorAndSizeMapper colorAndSizeMapper;
    @Override
    public int add(ColorAndSize colorAndSize) throws ServiceException {


        int row = colorAndSizeMapper.insert(colorAndSize);
        if (row == 0){
            throw new ServiceException("colorAndSize表数据添加失败",40001);
        }

        return row;
    }
}
