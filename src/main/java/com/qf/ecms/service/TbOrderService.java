package com.qf.ecms.service;

import java.util.List;

public interface TbOrderService {
    //单个订单的删除
    int tbOrderDelete(String orderNo);
    //批量删除
    int tbOrderDeleteBatch(List<String> list);
    //根据订单号 修改订单的发货状态
    int tbOrderUpdateStatus(String orderNo,int status);
}
