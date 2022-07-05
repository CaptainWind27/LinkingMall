package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommoditySpu implements Serializable {

    private static final long serialVersionUID = -8937390806854425788L;
    int id;
    String goodsName;
    float lowPrice;
    int categoryID;
    int brandID;
}
