package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.CommodityDetailDto;
import com.qf.ecms.service.CommodityDetailService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品详细信息控制层
 */
@RestController
@RequestMapping("/commodityDetail")
public class CommodityDetailController {
    @Resource
    CommodityDetailService commodityDetailService;

    @GetMapping("/info")
    ResponseEntity<CommodityDetailDto> commodityDetailInfo(@RequestParam int cid) {
        ResponseEntity<CommodityDetailDto> re = new ResponseEntity<>();
        try{
            CommodityDetailDto cdd = commodityDetailService.findAllCommodityDetail(cid);
            if(cdd!=null){
                re = re.success(cdd);
            }else {
                re = re.error(ErrorStatus.DATA_ERROR);
            }
        }catch (Exception e){
            re = re.error();
        }
        return re;
    }
}
