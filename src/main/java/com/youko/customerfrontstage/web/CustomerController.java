package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.dto.customer.CustomerLoginDto;
import com.youko.customerfrontstage.dto.customer.CustomerRegisterDto;
import com.youko.customerfrontstage.service.CustomerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**注册接口*/
    @PostMapping("/customer/register")
    public String saveCustomer(@RequestBody CustomerRegisterDto customerRegisterDto){
        if(customerRegisterDto==null){
            return "操作失败";
        }
        if(customerRegisterDto.getName()==null||customerRegisterDto.getPassword()==null){
            return "操作失败";
        }
        Customer customer=new Customer();
        customer.setName(customerRegisterDto.getName());
        customer.setPassword(passwordEncoder.encode(customerRegisterDto.getPassword()));
        customer.setMobile(customerRegisterDto.getMobile());
        customer.setRole("user");
        if (!(customerService.selectCustomer(customer)==null)){
            return "此账号密码重复";
        }
        customerService.saveCustomer(customer);
        return "操作成功";
    }


    /**登陆接口*/
    @PostMapping("/customer/login")
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

    /**user访问权限*/
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/user")
    public String user(){
        return "user访问";
    }

    /**admin访问权限*/
    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("/admin")
    public String admin(){
        return "admin访问";
    }


    /**修改密码接口*/
    @PutMapping ("/customer/updatePassword")
    public int updatePassword(@RequestBody String newPassword){
        return customerService.updatePassword(newPassword);
    }
}
