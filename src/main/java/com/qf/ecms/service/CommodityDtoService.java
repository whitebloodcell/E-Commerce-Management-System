package com.qf.ecms.service;

import com.qf.ecms.domain.dto.CommodityDto;

import java.util.Date;
import java.util.List;

public interface CommodityDtoService {
    List<CommodityDto> query(int cid, String title, Date time, int limit, int offset);
}
