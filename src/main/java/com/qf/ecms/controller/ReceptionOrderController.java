package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.ReceptionOrderDto;
import com.qf.ecms.service.ReceptionOrderService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ReceptionOrderController {

    @Resource
    ReceptionOrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<Integer> addOrder(@RequestBody ReceptionOrderDto receptionOrderDto){
        int count = orderService.addOrder(receptionOrderDto);
        return ResponseEntity.success(count);
    }


}
