package com.youko.customerfrontstage.bean;

import com.nh.micro.ext.ExtBeanWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityAttribution {
    private int id;
    private String name;
    private int commodityID;
    private List attr_value;
}
