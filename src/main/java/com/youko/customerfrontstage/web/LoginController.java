package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.service.CustomerService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("getCustomer/{id}")
    public String getCustomer(@PathVariable int id){
        return customerService.sel(id).toString();
    }


}
