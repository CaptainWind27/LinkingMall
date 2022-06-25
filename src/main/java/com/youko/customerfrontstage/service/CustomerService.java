package com.youko.customerfrontstage.service;


import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**保存客户信息*/
    public void saveCustomer(Customer customer){
        customerMapper.insertCustomer(customer);
    }

    /**根据用户名查询客户信息*/
    public Customer getCustomer(String name){
        return customerMapper.getCustomerByName(name);
    }

    /**修改密码*/
    public int updatePassword(String newPassword){
        UserDetails principal=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name=principal.getUsername();

        Customer customer=customerMapper.getCustomerByName(name);

        //此处实际应为检测手机短信之类的操作，或者直接在个人中心修改
        return customerMapper.updatePassword(name,passwordEncoder.encode(newPassword));
    }

    /**
     * 添加图片文件服务器端路径
     * @param id
     * @param path
     */
    public void updateCustomerPhotoPath(int id,String path){
        customerMapper.updateCustomerPhotoPath(id,path);
    }







}
