package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.CommodityDetailDto;
import com.qf.ecms.domain.entity.ColorSize;
import com.qf.ecms.domain.entity.CommodityPicture;
import com.qf.ecms.mapper.ColorSizeMapper;
import com.qf.ecms.mapper.CommodityDetailMapper;
import com.qf.ecms.mapper.CommodityMapper;
import com.qf.ecms.mapper.CommodityPictureMapper;
import com.qf.ecms.service.CommodityDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品详情信息业务层
 */
@Service
public class CommodityDetailServiceImpl implements CommodityDetailService {
    @Resource
    CommodityDetailMapper commodityDetailMapper;
    @Resource
    ColorSizeMapper colorSizeMapper;
    @Resource
    CommodityPictureMapper commodityPictureMapper;

    /**
     * 根据商品id找到商品的所有详细信息
     *
     * 1.查找商品信息和详情信息
     * 2.查找商品颜色尺寸等信息
     * 3.查找商品图片
     * @param cid
     * @return
     */
    @Override
    public CommodityDetailDto findAllCommodityDetail(int cid) {
        //组装数据
        //查找商品信息和详情信息
        CommodityDetailDto commodityDetailDto = commodityDetailMapper.selectAllCommodityDetail(cid);
        //查找商品颜色尺寸等信息
        List<ColorSize> colorSizes = colorSizeMapper.SelectALlColorSizeByCid(cid);
        commodityDetailDto.setColorSize(colorSizes);
        //查找商品图片
        List<CommodityPicture> commodityPictures = commodityPictureMapper.selectAllPicByCid(cid);
        commodityDetailDto.setCommodityPicture(commodityPictures);
        return commodityDetailDto;
    }
}
