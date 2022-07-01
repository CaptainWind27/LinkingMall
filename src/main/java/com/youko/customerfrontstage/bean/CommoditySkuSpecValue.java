package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySkuSpecValue  implements Serializable {
    int id;
    int skuID;
    int specValueID;
}
