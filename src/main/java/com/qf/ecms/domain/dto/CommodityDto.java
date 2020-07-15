package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.ColorAndSize;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.domain.entity.CommodityDetail;
import com.qf.ecms.domain.entity.CommodityPicture;
import lombok.Data;

@Data
public class CommodityDto {
    private Commodity commodity;
    private CommodityDetail commodityDetail;
    private ColorAndSize colorAndSize;
    private CommodityPicture commodityPicture;
}
