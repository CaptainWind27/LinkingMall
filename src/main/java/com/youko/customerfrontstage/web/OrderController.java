package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Order;
import com.youko.customerfrontstage.bean.OrderSku;
import com.youko.customerfrontstage.dto.commodity.OrderDto;
import com.youko.customerfrontstage.dto.commodity.OrderHistoryDto;
import com.youko.customerfrontstage.dto.commodity.OrderSkuDto;
import com.youko.customerfrontstage.mapper.OrderMapper;
import com.youko.customerfrontstage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderController
 * @Description: some desc
 * @date: 2022/7/8 10:59
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMapper orderMapper;

    @PostMapping("/user/order/addOrder")
    public String addOrder(@RequestBody OrderDto orderDto) {
        List<OrderSku> orderSkus = new ArrayList<>();
        List<OrderSkuDto> orderSkuDtos = orderDto.getOrderSkuDtos();
        for (OrderSkuDto orderSkuDto : orderSkuDtos) {
            OrderSku orderSku = new OrderSku();
            orderSku.setSkuID(orderSkuDto.getSkuID());
            orderSku.setNum(orderSkuDto.getNum());
            orderSku.setOrderID(0);
            orderSkus.add(orderSku);
        }

        int i = orderService.addOrder(orderDto.getCustomerID(), orderDto.getAddress(), orderSkus);
        if (i > 0)
            return "成功";
        else return "失败";
    }

    @GetMapping("/user/order/getAll")
    public List<OrderHistoryDto> getCustomerOrder(@Param("customerID")int customerID){
        return orderService.getCustomerAll(customerID);
    }

}
