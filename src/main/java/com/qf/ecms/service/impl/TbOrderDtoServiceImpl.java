package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.TbOrderDto;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.TbOrderDtoMapper;
import com.qf.ecms.service.TbOrderDtoService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbOrderDtoServiceImpl implements TbOrderDtoService {

    @Resource
    TbOrderDtoMapper tbOrderDtoMapper;
    @Override
    public List<TbOrderDto> queryAll() {
        List<TbOrderDto> list = tbOrderDtoMapper.selectAll();
        System.out.println(list);
        if (list == null){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }
        return list;
    }
}
