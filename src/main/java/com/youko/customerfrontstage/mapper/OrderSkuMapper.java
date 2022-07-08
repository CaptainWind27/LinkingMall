package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.OrderSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderSkuMapper {
    /**
     * 插入订单里中的商品列表
     * @return
     */
    int insertOrderSku(OrderSku orderSku);

    /**
     *
     * @param orderID
     * @return
     */
    List<OrderSku> getOrderSku(int orderID);
}
