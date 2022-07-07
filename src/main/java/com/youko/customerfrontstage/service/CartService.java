package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.*;
import com.youko.customerfrontstage.dto.cart.CartItemDto;
import com.youko.customerfrontstage.mapper.CartMapper;
import com.youko.customerfrontstage.mapper.CommoditySpuMapper;
import com.youko.customerfrontstage.mapper.PictureMapper;
import com.youko.customerfrontstage.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CartService
 * @Description: some desc
 * @date: 2022/7/5 14:08
 */
@Service
public class CartService {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    PictureMapper pictureMapper;
    public int insertItem(int customerID,int skuID,int num){
        CartItem cartItem = new CartItem();
        cartItem.setNum(num);
        cartItem.setSkuID(skuID);
        cartItem.setCustomerID(customerID);
        cartMapper.insert(cartItem);
        return cartItem.getId();
    }

    public int updateNum(int id,int num){
        CartItem result = cartMapper.findCartItemByID(id);
        if (result == null) {
            return -1;
        }

        // 判断查询结果中的uid与参数uid是否不匹配
        if (result.getId()!=id) {
            return -1;
        }
        return cartMapper.updateNumById(id,num);
    }

    public List<CartItemDto> getCartSpu(int customerID){
        List<CartItem> cartItems = cartMapper.findByCustomerID(customerID);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setCartID(cartItem.getId());
            cartItemDto.setCommoditySku(skuMapper.findOneSku(cartItem.getSkuID()));
            cartItemDto.setNum(cartItem.getNum());
            String picPath= pictureMapper.getMainPagePic(skuMapper.findOneSku(cartItem.getSkuID()).getSpuID()).getPicPath();
            List<CommoditySkuSpecValue> ssv = skuMapper.findSSV(cartItem.getSkuID());
            List<CommoditySpecValue> sv = new ArrayList<>();
            for (CommoditySkuSpecValue commoditySkuSpecValue : ssv) {
                sv.add(skuMapper.findSVByID(commoditySkuSpecValue.getSpecValueID()));
            }
            cartItemDto.setSpecValues(sv);
            cartItemDto.setPicPath(picPath);
            cartItemDtos.add(cartItemDto);
        }
        return cartItemDtos;

    }

}
