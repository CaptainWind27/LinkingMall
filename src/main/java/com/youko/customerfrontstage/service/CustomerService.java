package com.youko.customerfrontstage.service;


import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public void saveCustomer(Customer customer){
        customer.setId((int) (Math.random()*1000+1));
        customerMapper.insertCustomer(customer);
    }

    public Customer selectCustomer(Customer customer){
        if(customer.getName()==null||customer.getPassword()==null){
            return null;
        }
        return customerMapper.selectOneCustomer(customer);
    }

}
