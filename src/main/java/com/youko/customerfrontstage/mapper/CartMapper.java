package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    /**
     * 添加
     * @param cartItem 购物车项
     * @return 受影响的行数
     */
    int insert(CartItem cartItem);

    /**
     * 当不是第一次向购物车添加就会增加数量
     * @param id 购物车项的id
     * @param num 购买1量
     * @return 受影响的行数
     */
    int updateNumById(int id,int num);

    /**
     * 查找，通过用户和商品id查找
     * @param customerID 用户id
     * @return 购物车项
     */
    List<CartItem> findByCustomerID(int customerID);

    /**
     * 通过id查询某个购物车项是否存在
     * @param id 购物车项的id
     * @return 购物车项
     */
    CartItem findCartItemByID(int id);
}
