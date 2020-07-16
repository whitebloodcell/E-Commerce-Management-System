package com.qf.ecms.service;

import com.qf.ecms.domain.dto.CommodityDetailDto;

/**
 * 商品详情信息业务层
 */
public interface CommodityDetailService {

    /**
     * 根据商品id找到商品的所有详细信息
     * @param cid
     * @return
     */
    CommodityDetailDto findAllCommodityDetail (int cid);
}
