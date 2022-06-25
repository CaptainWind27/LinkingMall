package com.youko.customerfrontstage.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginResponseDto extends ResponseDto{
    private int id;
    private String name;
    private String nickname;
    private String portrait;//头像
}
