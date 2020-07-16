package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.CommodityDetail;
import org.apache.ibatis.annotations.Param;
import com.qf.ecms.domain.dto.CommodityDetailDto;import com.qf.ecms.domain.entity.CommodityDetail;import org.apache.ibatis.annotations.Param;

public interface CommodityDetailMapper {
    int deleteByPrimaryKey(Integer cdid);

    int insert(CommodityDetail record);

    int insertSelective(CommodityDetail record);

    CommodityDetail selectByPrimaryKey(Integer cdid);

    int updateByPrimaryKeySelective(CommodityDetail record);

    int updateByPrimaryKey(CommodityDetail record);

    int insertAllCommodity(@Param("commodityDetail") CommodityDetail commodityDetail);

    /**
     * 根据商品id查询商品相关的所有信息
     *
     * @param cid
     * @return
     */
    CommodityDetailDto selectAllCommodityDetail(@Param("cid") int cid);
}