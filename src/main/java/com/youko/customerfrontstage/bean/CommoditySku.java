package com.youko.customerfrontstage.bean;

import lombok.Data;

@Data
public class CommoditySku {
    int id;
    String skuNo;
    String skuName;
    float price;
    int stock;
    int sale;
    int merID;
    int spuID;
}
