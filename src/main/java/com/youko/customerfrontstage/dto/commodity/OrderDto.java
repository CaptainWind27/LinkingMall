package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.OrderSku;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderDto
 * @Description: some desc
 * @date: 2022/7/8 10:51
 */
@Data
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -6390719365965585216L;
    int customerID;
    String address;
    List<OrderSkuDto> orderSkuDtos;
}
