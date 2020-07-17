package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.TbOrder;
import com.qf.ecms.service.TbOrderService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TbOrderController {

    @Resource
    TbOrderService tbOrderService;

    /*
    * 单个订单删除  修改字段 = 逻辑删除
    * */
    @PostMapping("/tbOrderDelete")
    public ResponseEntity tbOrderDelete(String orderNo){
        int row = tbOrderService.tbOrderDelete(orderNo);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }

    /*
    * 批量删除 传入list数组
    * */
    @PostMapping("/tbOrderDeleteBatch")
    public ResponseEntity tbOrderDeleteBatch(@RequestBody List<String> list){
        int row = tbOrderService.tbOrderDeleteBatch(list);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }

    /*
    * 根据订单号 修改订单的发货状态  传入状态码,订单号
    * */
    @PostMapping("/tbOrderUpdateStatus")
    public ResponseEntity tbOrderUpdateStatus(String orderNo,int status){
        int row = tbOrderService.tbOrderUpdateStatus(orderNo, status);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }

}
