package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorSize;import org.apache.ibatis.annotations.Param;

public interface ColorSizeMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(ColorSize record);

    int insertSelective(ColorSize record);

    ColorSize selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(ColorSize record);

    int updateByPrimaryKey(ColorSize record);

    /**
     * 根据颜色尺寸表主键查询当前商品的信息
     *
     * @param csid
     * @return
     */
    int SelectStockByCsid(@Param("csid") int csid);
}