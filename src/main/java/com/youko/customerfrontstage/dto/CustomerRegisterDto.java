package com.youko.customerfrontstage.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterDto {
    private String name;
    private String password;
    private String mobile;
}
