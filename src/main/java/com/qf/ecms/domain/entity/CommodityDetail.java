package com.qf.ecms.domain.entity;

import lombok.Data;


import java.util.Date;

@Data
public class CommodityDetail {
    private Integer cdid;
    private String detailsContent;
    private String model;
    private Double weight;
    private Date createTime;
    private Integer cid;

}
