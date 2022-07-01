package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpu implements Serializable {

    private static final long serialVersionUID = -8937390806854425788L;
    int id;
    String spuNo;
    String goodsName;
    float lowPrice;
    int categoryID;
    int brandID;
}
