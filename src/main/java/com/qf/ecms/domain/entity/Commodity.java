package com.qf.ecms.domain.entity;

import lombok.Data;

@Data
public class Commodity {
    private Integer cid;
    private String commodityTitle;
    private String commodityPicture;
    private Integer ssid;
    private Integer psid;
    private Integer isNew;
    private Integer enable;

}
