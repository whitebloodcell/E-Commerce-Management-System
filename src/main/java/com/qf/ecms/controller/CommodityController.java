package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CommodityController {
    @Resource
    CommodityService commodityService;


    /*
    * 联合4个表的同时商品信息添加
    * */
    @PostMapping("/commodityAdd")
    public ResponseEntity commodityAdd(@RequestBody CommodityDto commodityDto) throws ServiceException {

        int row = commodityService.add(commodityDto);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }

    /*
    * 4个表的可能需要修改数据,不一定修改全部
    * */
    @PostMapping("/commodityUpdate")
    public ResponseEntity commodityUpdate(@RequestBody CommodityDto commodityDto){
        int row = commodityService.update(commodityDto);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }


    /*
    * 删除
    * 分为停用和逻辑删除
    * 只有一个表的字段
    * */
    @PostMapping("/commodityDelete")
    public ResponseEntity commodityDelete(int enable,int cid){
        int row = commodityService.delete(enable, cid);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }

    /*
    * 查询已下架的商品
    * */
    @PostMapping("/commoditySelectDown")
    public ResponseEntity<List<Commodity>> commoditySelectDown(int enable){
        List<Commodity> commodities = commodityService.selectDown(enable);
        if (commodities != null) {
            return ResponseEntity.success(commodities);
        }else {
            return ResponseEntity.error();
        }
    }

    /*
    * 批量删除商品
    * */
    @PostMapping("/commodityBatchDelete")
    public ResponseEntity commodityBatchDelete(@RequestBody List<Integer> list){
        int row = commodityService.deleteBatch(list);
        if (row != 0){
            return ResponseEntity.success(ErrorStatus.SUCCESS);
        }else {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        }
    }
}
