package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PicturePath implements Serializable {
    private static final long serialVersionUID = -1908085151772237259L;
    int id;
    String picPath;
    int spuID;
    boolean mainPagePic;
}
