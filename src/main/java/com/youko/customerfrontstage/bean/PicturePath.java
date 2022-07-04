package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PicturePath implements Serializable {
    int id;
    String picPath;
    int spuID;
    boolean mainPagePic;
}
