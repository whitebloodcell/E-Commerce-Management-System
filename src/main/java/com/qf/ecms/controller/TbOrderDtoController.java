package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.TbOrderDto;
import com.qf.ecms.service.TbOrderDtoService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TbOrderDtoController {
    @Resource
    TbOrderDtoService tbOrderDtoService;
    @PostMapping("/tbOrderDtoQueryAll")
    public ResponseEntity<List<TbOrderDto>> tbOrderDtoQueryAll(){
        List<TbOrderDto> list = tbOrderDtoService.queryAll();
        if (list != null){
            return ResponseEntity.success(list);
        }else {
            return ResponseEntity.error();
        }
    }
}
