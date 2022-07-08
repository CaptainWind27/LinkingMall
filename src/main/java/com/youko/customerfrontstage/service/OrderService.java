package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.Order;
import com.youko.customerfrontstage.bean.OrderSku;
import com.youko.customerfrontstage.dto.commodity.OrderDto;
import com.youko.customerfrontstage.dto.commodity.OrderHistoryDto;
import com.youko.customerfrontstage.dto.commodity.OrderSkuDto;
import com.youko.customerfrontstage.mapper.OrderMapper;
import com.youko.customerfrontstage.mapper.OrderSkuMapper;
import com.youko.customerfrontstage.mapper.PictureMapper;
import com.youko.customerfrontstage.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderService
 * @Description: some desc
 * @date: 2022/7/8 10:15
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderSkuMapper orderSkuMapper;
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    PictureMapper pictureMapper;

    public int addOrder(int customerID, String address, List<OrderSku> orderSkus) {
        Order order = new Order();
        order.setCustomerID(customerID);
        order.setAddress(address);
        order.setTotalPrice(0);
        Date date = new Date();
        int totalPrice = 0;
        order.setPayTime(date);
        int n = 0;
        int i = orderMapper.insertOrder(order);
        for (OrderSku skus : orderSkus) {
            skus.setOrderID(order.getId());
            skus.setSkuID(skus.getSkuID());
            skus.setNum(skus.getNum());
            totalPrice += skuMapper.findOneSku(skus.getSkuID()).getPrice() * skus.getNum();
            n = orderSkuMapper.insertOrderSku(skus);
        }
        orderMapper.updatePrice(totalPrice, order.getId());
        if (i > 0 && n > 0)
            return 1;
        else return 0;
    }

    public List<OrderHistoryDto> getCustomerAll(int customerID) {
        List<OrderHistoryDto> orderHistoryDtos = new ArrayList<>();
        List<Order> orders = orderMapper.getCustomerOrder(customerID);
        for (Order order : orders) {
            OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
            orderHistoryDto.setOrderID(order.getId());
            orderHistoryDto.setPayTime(order.getPayTime());
            orderHistoryDto.setPrice(order.getTotalPrice());
            List<OrderSku> orderSkus = orderSkuMapper.getOrderSku(order.getId());
            orderHistoryDto.setNumOfSku(orderSkus.size());
            List<OrderSkuDto> orderSkuDtos = new ArrayList<>();
            for (OrderSku skus : orderSkus) {
                OrderSkuDto orderSkuDto = new OrderSkuDto();
                orderSkuDto.setSkuID(skus.getSkuID());
                orderSkuDto.setNum(skus.getNum());
                orderSkuDto.setPicPath(pictureMapper.getMainPagePic(skuMapper.findOneSku(skus.getSkuID()).getSpuID()).getPicPath());
                orderSkuDtos.add(orderSkuDto);
            }
            orderHistoryDto.setOrderSkuDtos(orderSkuDtos);
            orderHistoryDtos.add(orderHistoryDto);
        }

        return orderHistoryDtos;
    }
}
