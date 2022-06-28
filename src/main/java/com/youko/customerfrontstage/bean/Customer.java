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

    private static final long serialVersionUID = 8733777551777775250L;
    private int id;

    private String name;

    private String password;

    private String avatar;

    private String mobile;

    private String role;

    private String nickname;


    public Customer(String name, String encode) {
    }
}