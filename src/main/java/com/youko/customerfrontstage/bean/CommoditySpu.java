package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpu  implements Serializable {
    int id;
    String spuNo;
    String goodsName;
    float lowPrice;
    int categoryID;
    int brandID;
}
