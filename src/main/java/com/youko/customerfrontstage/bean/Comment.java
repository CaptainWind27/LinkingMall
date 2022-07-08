package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: Comment
 * @Description: some desc
 * @date: 2022/7/7 17:06
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 3674642756568880209L;
    int id;
    String spuComment;
    int spuID;
    String customerName;
}
