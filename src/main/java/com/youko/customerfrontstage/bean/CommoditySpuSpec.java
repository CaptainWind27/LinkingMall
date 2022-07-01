package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommoditySpuSpec implements Serializable {

    private static final long serialVersionUID = -7813986286661726674L;
    int id;
    int spuID;
    int specID;
}
