package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: CartItem
 * @Description: 放在购物车里的实体类
 * @date: 2022/7/5 11:07
 */
@Data
public class CartItem implements Serializable {
    //购物车项的id
    int id;
    //sku的id
    int skuID;
    //用户的id
    int customerID;
    //所购买商品的数量
    int num;
}
