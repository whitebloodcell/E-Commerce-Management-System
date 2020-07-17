package com.qf.ecms.service.impl;

import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.TbOrderMapper;
import com.qf.ecms.service.TbOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    TbOrderMapper tbOrderMapper;


    @Override
    public int tbOrderDelete(String orderNo) {
        int row = 0;
        if (orderNo != null) {  //删除订单,订单号是条件,不能为null
            row = tbOrderMapper.tbOrderDelete(orderNo);
        } else {
            throw new DaoException("请输入你想删除的订单号", 44000);
        }
        return row;
    }

    @Override
    public int tbOrderDeleteBatch(List<String> list) {
        int row = 0 ;
        if (list != null){   //批量删除,传入的多个订单号不能为null
            row = tbOrderMapper.tbOrderDeleteBatch(list);
        }else {
            throw new DaoException("请输入你想删除的多个订单号",44000);
        }
        return row;
    }

    @Override
    public int tbOrderUpdateStatus(String orderNo, int status) {
        int row = 0;
        if (orderNo != null && status >= 0 && status <=4){  //修改订单状态,状态码要在0--4中选
            row = tbOrderMapper.tbOrderUpdateStatus(orderNo, status);
        }else {
            throw new DaoException("请输入正确的订单号或者状态码",44000);
        }
        return row;
    }
}
