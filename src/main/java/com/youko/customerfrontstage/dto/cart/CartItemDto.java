package com.youko.customerfrontstage.dto.cart;

import com.youko.customerfrontstage.bean.CommoditySku;
import com.youko.customerfrontstage.bean.CommoditySkuSpecValue;
import com.youko.customerfrontstage.bean.CommoditySpecValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CartItemDto
 * @Description: some desc
 * @date: 2022/7/6 10:09
 */
@Data
public class CartItemDto implements Serializable {
//    id: 10,
//    image: 'atic/默认商品.png',
//    attr_val: '规格',
//    stock: 15,
//    title: '商品13',
//    price: 1089.00,
//    number: 1
    int cartID;
    CommoditySku commoditySku;
    String picPath;
    int num;
    List<CommoditySpecValue> specValues;
}
