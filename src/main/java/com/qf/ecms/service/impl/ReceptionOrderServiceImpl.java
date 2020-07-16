package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.ReceptionOrderDto;
import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.service.ReceptionOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionOrderServiceImpl implements ReceptionOrderService {




    @Override
    public int addOrder(ReceptionOrderDto receptionOrderDto) {
        int userId = receptionOrderDto.getUserId();
        List<ShopCart> shopCarts = receptionOrderDto.getShopCarts();



        return 0;
    }
}
