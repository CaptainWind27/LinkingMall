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
    private String name;
    //商品的名字
    private float price;
    //商品价格
    private int id;
    //唯一标识商品的编号
    private String nameOfMer;
    //所属商户的名字
    private String picPath;
    //存放图片的路径
    private String description;
    //商品的描述
    private String specs;
    //商品的规格，即商品的具体参数
    private String tag;
    //商品会附加的tag
}
