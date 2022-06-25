package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {
    /**
     * 保存客户信息（name，password）
     * @param customer
     */
    void insertCustomer(Customer customer);


    /**
     * 通过name查找客户
     * @param name
     * @return
     */
    Customer getCustomerByName(String name);


    /**
     * 更新密码
     * @param name
     * @param newPassword
     * @return
     */
    int updatePassword(String name,String newPassword);

    /**修改头像图片路径
     *
     */
    int updateCustomerPhotoPath(int id,String customerPhotoPath);

}
