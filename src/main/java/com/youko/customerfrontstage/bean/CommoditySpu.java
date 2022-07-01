package com.youko.customerfrontstage.bean;

import lombok.Data;

@Data
public class CommoditySpu {
    int id;
    String spuNo;
    String goodsName;
    float lowPrice;
    int categoryID;
    int brandID;
}
