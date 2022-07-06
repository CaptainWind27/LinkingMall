package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: CartSpu
 * @Description: some desc
 * @date: 2022/7/6 9:44
 */
@Data
public class CartSpu implements Serializable {
    CartItem cartItem;
    CommoditySpu commoditySpu;
}
