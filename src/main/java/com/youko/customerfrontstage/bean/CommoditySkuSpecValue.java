package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySkuSpecValue implements Serializable {

    private static final long serialVersionUID = -4195055037088244656L;
    int id;
    int skuID;
    int specValueID;
}
