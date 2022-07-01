package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySku implements Serializable {
    int id;
    String skuNo;
    String skuName;
    float price;
    int stock;
    int sale;
    int merID;
    int spuID;
}
