package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: youko
 * @classname: Sort
 * @Description: some desc
 * @date: 2022/7/1 10:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sort {
    /**
     * 字段名
     */
    private String field;
    /**
     * 升序,asc,desc
     */
    private String order;
}
