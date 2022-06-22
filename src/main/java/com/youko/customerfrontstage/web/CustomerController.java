package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.dto.CustomerLoginDto;
import com.youko.customerfrontstage.dto.CustomerRegisterDto;
import com.youko.customerfrontstage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerRegisterDto customerRegisterDto){
        if(customerRegisterDto==null){
            return "操作失败";
        }
        if(customerRegisterDto.getName()==null||customerRegisterDto.getPassword()==null){
            return "操作失败";
        }
        Customer customer=new Customer();
        customer.setName(customerRegisterDto.getName());
        customer.setPassword(customerRegisterDto.getPassword());
        customer.setMobile(customerRegisterDto.getMobile());
        if (!(customerService.selectCustomer(customer)==null)){
            return "此账号密码重复";
        }
        customerService.saveCustomer(customer);
        return "操作成功";
    }

    @PostMapping("/login")
    public String loginIn(@RequestBody CustomerLoginDto customerLoginDto){
        if (customerLoginDto==null){
            return "操作失败";
        }
        Customer customer=new Customer();
        customer.setName(customerLoginDto.getName());
        customer.setPassword(customerLoginDto.getPassword());
        if(customerService.selectCustomer(customer)==null){
            return "查无此号";
        }
        return "登陆成功";
    }

}
