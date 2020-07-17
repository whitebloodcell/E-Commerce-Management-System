package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);



    //添加商品到4个表中的一个
    int insertAllCommodity(@Param("commodity") Commodity commodity);

    //在任意一个表中修改任意的商品信息
    int updateCommodity(@Param("commodity") Commodity commodity);

    //修改商品的状态,删除或者下架
    int deleteCommodity(@Param("enable") int enable,@Param("cid") int cid);

    //查询下架商品
    List<Commodity> selectDownCommodity(@Param("enable") int enable);

    //批量删除商品
    int deleteBatchCommodity(@Param("listCid") List<Integer> listCid);
}