package com.qf.ecms.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class CommodityDetail {
    private Integer cdid;
    private String detailsContent;
    private String model;
    private Double weight;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer cid;

}
