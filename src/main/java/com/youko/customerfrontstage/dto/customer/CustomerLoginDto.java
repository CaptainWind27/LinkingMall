package com.youko.customerfrontstage.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**客户登陆信息封装类*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginDto {
    private String name;
    private String password;
}
