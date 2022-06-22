package com.youko.customerfrontstage.bean;

import lombok.Data;


import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;


    private int id;

    private String name;

    private String password;

    private String avatar;

    private String mobile;


}