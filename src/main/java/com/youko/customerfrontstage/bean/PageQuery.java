package com.youko.customerfrontstage.bean;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author: youko
 * @classname: PageQuery
 * @Description: some desc
 * @date: 2022/7/1 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery<T> {
    private PageInfo pageInfo;
    /**
     * 排序字段
     */
    private Sort sort;
    /**
     * 查询参数类
     */
    private T params;
    /**
     * 返回结果集
     */
    private List<T> results;
    /**
     * 不在T类中的参数
     */
    private Map<String, String> queryParam;
}
