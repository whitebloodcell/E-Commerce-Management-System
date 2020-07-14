package com.qf.ecms.service;

import com.qf.ecms.domain.entity.ColorAndSize;
import com.qf.ecms.exception.ServiceException;


public interface ColorAndSizeService {
    int add(ColorAndSize colorAndSize) throws ServiceException;
}
