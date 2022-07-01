package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个是商品的实体类，定义了商品的属性
 * 创建时间2022/6/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    //主页商品的id
    private int id;
    //商品的名字
    private String name;
    //商品的最低价格
    private float minPrice;
    //商品的最高价格，一种商品就和最低相同
    private float maxPrice;
    //商家的名字
    private String merName;
    //商家的id
    private int merID;
    //商品流览图的路径
    private String picPath;
    //商品的库存
    private int stock;
    //商品的销量
    private int sale;
    //商品的标签
    private String tag;
}
