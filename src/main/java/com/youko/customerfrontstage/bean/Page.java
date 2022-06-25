package com.youko.customerfrontstage.bean;

import lombok.Data;

import java.util.List;

/**
 * 这个是分页的页的实体，用于实现分页查询
 */
@Data
public class Page<T> {
    //分页的标号
    private int pageNum;
    //一个分页中的大小
    private int pageSize;
    //一个分页page中的数据<T>
    private List<T> dayaList;
    //page中的数据量
    //private int dataSize;
}
