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
    private static final long serialVersionUID = 6702537306499146020L;
    CartItem cartItem;
    CommoditySpu commoditySpu;
}
