package com.youko.customerfrontstage.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityAttribution {
    private int id;
    private String name;
    private String commodityID;
    private JSON attr_value;
}
