package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderSku
 * @Description: some desc
 * @date: 2022/7/8 9:57
 */
@Data
public class OrderSku implements Serializable {
    private static final long serialVersionUID = 1031115634067243242L;
    int id;
    int orderID;
    int skuID;
    int num;
}
