package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.mockito.internal.matchers.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: OrderMapper
 * @Description: some desc
 * @date: 2022/7/8 9:43
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 插入订单
     * @param order 订单
     * @return
     */
    int insertOrder(Order order);

    /**
     * 查询一个用户的订单
     * @param customerID
     * @return
     */
    List<Order> getCustomerOrder(int customerID);

    /**
     * 更改总价
     * @param price
     * @return
     */
    int updatePrice(int price,int orderID);

}
