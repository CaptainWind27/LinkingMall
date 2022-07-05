package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommodityCategory implements Serializable {
    int id;
    String categoryName;
    int categoryLevel;
    int parentID;
    String picPath;
}
