package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.bean.ReturnPojo;
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
    public ReturnPojo saveCustomer(@RequestBody CustomerRegisterDto customerRegisterDto){
        ReturnPojo returnPojo = new ReturnPojo();
        if(customerRegisterDto==null){
            returnPojo.setReString("操作失败");
            returnPojo.setReInt(1);
            return returnPojo;
        }
        if(customerRegisterDto.getName()==null||customerRegisterDto.getPassword()==null){
            returnPojo.setReString("操作失败");
            returnPojo.setReInt(1);
            return returnPojo;
        }
        Customer customer=new Customer();
        customer.setName(customerRegisterDto.getName());
        customer.setPassword(passwordEncoder.encode(customerRegisterDto.getPassword()));
        customer.setMobile(customerRegisterDto.getMobile());
        customer.setRole("user");
        if (!(customerService.selectCustomer(customer)==null)){
            returnPojo.setReString("此账号密码重复");
            /*
              1为出错误
              11为账号重复类型的错误
             */
            returnPojo.setReInt(11);
            return returnPojo;
        }
        customerService.saveCustomer(customer);
        returnPojo.setReString("操作成功");
        /*
          0为操作成功
         */
        returnPojo.setReInt(0);
        return returnPojo;
    }


    /**登陆接口*/
    @PostMapping("/customer/login")
    public ReturnPojo loginIn(@RequestBody CustomerLoginDto customerLoginDto){
        ReturnPojo returnPojo = new ReturnPojo();
        if (customerLoginDto==null){
            returnPojo.setReString("操作失败");
            returnPojo.setReInt(1);
            return returnPojo;
        }
        Customer customer=new Customer();
        customer.setName(customerLoginDto.getName());
        customer.setPassword(customerLoginDto.getPassword());
        if(customerService.selectCustomer(customer)==null){
            returnPojo.setReString("查无此号");
            /**
              12为为查找到的错误
             */
            returnPojo.setReInt(12);
            return returnPojo;
        }
        returnPojo.setReString("登陆成功");
        returnPojo.setReInt(0);
        return returnPojo;
    }

//    /**user访问权限*/
//    @PreAuthorize("hasAnyRole('user')")
//    @GetMapping("/user")
//    public String user(){
//        return "user访问";
//    }
//
//    /**admin访问权限*/
//    @PreAuthorize("hasAnyRole('admin')")
//    @GetMapping("/admin")
//    public String admin(){
//        return "admin访问";
//    }


    /**修改密码接口*/

    @PutMapping ("/customer/updatePassword")
    public int updatePassword(@RequestBody String newPassword){
        return customerService.updatePassword(newPassword);
    }
}
