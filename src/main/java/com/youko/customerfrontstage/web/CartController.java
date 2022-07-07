package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.dto.cart.CartItemDto;
import com.youko.customerfrontstage.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CartController
 * @Description: some desc
 * @date: 2022/7/5 14:11
 */
@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/user/cart/insert")
    public String addItem(@Param("customerID") int customerID,@Param("skuID") int skuID,@Param("num") int num){
        int i = cartService.insertItem(customerID,skuID,num);
        if (i>0){
            return "添加成功"+ i;
        }
        else
            return "添加失败";
    }

    @GetMapping("/user/cart/getAll")
    public List<CartItemDto> getAllCartItemByCustomerID(@Param("customerID")int customerID){
        return cartService.getCartSpu(customerID);
    }

    @GetMapping("/user/cart/updateNum")
    public String updateNum(@Param("cartID") int cartID,@Param("num") int num){
        int i = cartService.updateNum(cartID,num);
        if (i==-1)
            return "操作失败";
        else
            return "操作成功";
    }

}
