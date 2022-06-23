package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper {
    Customer selectOneCustomer(Customer customer);

    void insertCustomer(Customer customer);


    Customer getCustomerByName(String name);


    int updatePassword(String name,String newPassword);
}
