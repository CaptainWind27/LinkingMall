package com.youko.customerfrontstage.dto.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**客户注册信息封装类*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterDto {
    private String name;
    private String password;
    private String mobile;
}
