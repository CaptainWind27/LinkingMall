package com.youko.customerfrontstage.bean;

import lombok.Data;

/**
 * 用于后端给前端传递一些包装信息
 */
@Data
public class ReturnPojo {
    /**
     *返回的数组信息
     */
    String reString;
    //返回的数字
    int reInt;

}
