package com.qf.ecms.service;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.ServiceException;

public interface CommodityService {

    int add(CommodityDto commodityDto) throws ServiceException;

}
