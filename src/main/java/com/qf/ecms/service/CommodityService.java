package com.qf.ecms.service;

import com.qf.ecms.domain.entity.ColorAndSize;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.exception.ServiceException;
import org.apache.ibatis.annotations.Param;

public interface CommodityService {


    int add(Commodity commodity) throws ServiceException;

}
