package com.qf.ecms.service;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface CommodityService {

    int add(CommodityDto commodityDto) throws ServiceException;



}
