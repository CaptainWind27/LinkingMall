package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PicturePath implements Serializable {
    private static final long serialVersionUID = -1908085151772237259L;
    int id;
    String picPath;
    int spuID;
    boolean mainPagePic;
}
