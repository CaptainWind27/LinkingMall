package com.youko.customerfrontstage.dto.commodity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderHistoryDto
 * @Description: some desc
 * @date: 2022/7/8 14:33
 */
@Data
public class OrderHistoryDto implements Serializable {
    private static final long serialVersionUID = 5647571714099385431L;
    int orderID;
    Date payTime;
    int numOfSku;
    float price;
    List<OrderSkuDto> orderSkuDtos;
}
