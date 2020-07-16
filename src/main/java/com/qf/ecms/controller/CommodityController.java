package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommodityController {
    @Resource
    CommodityService CommodityService;

    @PostMapping("/commodityAdd")
    public ResponseEntity commodityAdd(@RequestBody CommodityDto commodityDto) throws ServiceException {

        int row = CommodityService.add(commodityDto);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.success(ErrorStatus.SERVICE_ERROR);
        }
    }
}
