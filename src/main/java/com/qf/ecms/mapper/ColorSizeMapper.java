package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ColorSize;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColorSizeMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(ColorSize record);

    int insertSelective(ColorSize record);

    ColorSize selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(ColorSize record);

    int updateByPrimaryKey(ColorSize record);




    //添加商品到4个表中的一个
    int insertAllCommodity(@Param("colorSize") ColorSize colorSize);

    /**
     * 根据颜色尺寸表主键查询当前商品的信息
     *
     * @param csid
     * @return
     */
    int selectStockByCsid(@Param("csid") int csid);

    /**
     * 根据商品id查询所有的颜色尺寸信息
     * @param cid
     * @return
     */
    List<ColorSize> SelectALlColorSizeByCid(@Param("cid") int cid);

    //在任意一个表中修改任意的商品信息
    int updateColorSize(@Param("colorSize") ColorSize colorSize);
}