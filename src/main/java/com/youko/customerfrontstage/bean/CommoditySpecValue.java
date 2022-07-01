package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpecValue  implements Serializable {
    int id;
    int specID;
    String specValue;
}
