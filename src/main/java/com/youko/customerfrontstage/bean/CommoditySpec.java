package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpec  implements Serializable {
    int id;
    String specNo;
    String specName;
}
