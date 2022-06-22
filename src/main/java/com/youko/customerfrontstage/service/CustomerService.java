package com.youko.customerfrontstage.service;


import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    public Customer sel(int id){
        return customerMapper.sel(id);
    }
}
