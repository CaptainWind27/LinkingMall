package com.youko.customerfrontstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: youko
 * @classname: PageInfo
 * @Description: some desc
 * @date: 2022/7/1 16:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    /**
     * 当前页数
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;
}
