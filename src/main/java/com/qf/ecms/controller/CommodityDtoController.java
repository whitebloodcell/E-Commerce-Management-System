package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.service.CommodityDtoService;
import com.qf.ecms.utils.ErrorStatus;

import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class CommodityDtoController {
    @Resource
    CommodityDtoService commodityDtoService;

    @PostMapping("/commoditySelect")
    public ResponseEntity<List<CommodityDto>> commoditySelect(@RequestBody CommodityDto commodityDto){
        List<CommodityDto> list = commodityDtoService.query(commodityDto);
        if (list != null){
            return ResponseEntity.success(list);
        }else {
            return ResponseEntity.error();
        }
    }

}
