package com.qf.ecms.domain.dto;

import com.qf.ecms.domain.entity.ShopCart;
import lombok.Data;

import java.util.List;

@Data
public class ReceptionOrderDto {
    private Integer userId;
    private List<ShopCart> shopCarts;
}
