package com.youko.customerfrontstage.dto.commodity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderSkuDto
 * @Description: some desc
 * @date: 2022/7/8 10:53
 */
@Data
public class OrderSkuDto implements Serializable {

    private static final long serialVersionUID = 6720228464806972650L;
    int skuID;
    int num;
    String picPath;
}
