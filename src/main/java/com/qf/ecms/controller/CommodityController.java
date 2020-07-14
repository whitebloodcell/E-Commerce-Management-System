package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.CommodityDto;

import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.ColorAndSizeService;
import com.qf.ecms.service.CommodityDetailService;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommodityController {
    @Resource
    CommodityService commodityService;
    @Resource
    CommodityDetailService commodityDetailService;
    @Resource
    ColorAndSizeService colorAndSizeService;

    @PostMapping("/commodityAdd")
    @Transactional
    public ResponseEntity commodityAdd(@RequestBody CommodityDto commodityDto) throws ServiceException {


            commodityService.add(commodityDto.getCommodity());



            Integer cid = commodityDto.getCommodity().getCid();
            //先创建commodity的数据,才有Cid,下面的数据添加需要cid
            commodityDto.getCommodityDetail().setCid(cid);
            commodityDto.getColorAndSize().setCid(cid);


            commodityDetailService.add(commodityDto.getCommodityDetail());
            colorAndSizeService.add(commodityDto.getColorAndSize());


            return ResponseEntity.success(ErrorStatus.SUCCESS);



    }



}
