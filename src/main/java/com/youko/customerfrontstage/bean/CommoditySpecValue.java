package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpecValue implements Serializable {

    private static final long serialVersionUID = 5336394204949960113L;
    int id;
    int specID;
    String specValue;
}
