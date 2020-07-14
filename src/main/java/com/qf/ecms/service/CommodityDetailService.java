package com.qf.ecms.service;

import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.exception.ServiceException;


public interface CommodityDetailService {
    int add(CommodityDetail commodityDetail) throws ServiceException;
}
