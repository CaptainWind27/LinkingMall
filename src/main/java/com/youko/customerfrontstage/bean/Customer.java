package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**客户信息类*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String password;

    private String avatar;

    private String mobile;

    private String role;


    public Customer(String name, String encode) {
    }
}