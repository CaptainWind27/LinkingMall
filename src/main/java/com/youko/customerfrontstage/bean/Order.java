package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Iowa Class Battleship
 * @classname: Order
 * @Description: some desc
 * @date: 2022/7/8 9:40
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 925884242521211378L;
    int id;
    int customerID;
    float totalPrice;
    String address;
    Date payTime;
}
