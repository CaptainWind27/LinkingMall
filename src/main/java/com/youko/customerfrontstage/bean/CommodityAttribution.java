package com.youko.customerfrontstage.bean;

import com.nh.micro.ext.ExtBeanWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityAttribution implements Serializable {

    private static final long serialVersionUID = 9050218517554058800L;
    private int id;
    private String name;
    private int commodityID;
    private List attr_value;
}
