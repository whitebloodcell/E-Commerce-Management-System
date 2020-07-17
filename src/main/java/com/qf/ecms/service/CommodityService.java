package com.qf.ecms.service;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface CommodityService {
    //4个商品数据表的数据添加,Dto对象
    int add(CommodityDto commodityDto) throws ServiceException;
    //修改数据,Dto对象
    int update(CommodityDto commodityDto);
    //删除只需要修改一个状态字段,和一个条件
    int delete(int enable,int cid);
    //下架商品的查询
    List<Commodity> selectDown(int enable);
    //批量删除商品
    int deleteBatch(List<Integer> list);


}
