package com.youko.customerfrontstage.dao;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

public interface ILuceneDao {
    /**
     * 创建索引
     * @param productList
     * @throws IOException
     */
    public void createCommoditySpuIndex(List<CommoditySpu> productList) throws IOException;
    /**
     * 查询索引
     * @param pageQuery
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public PageQuery<CommoditySpu> searchCommoditySpu(PageQuery<CommoditySpu> pageQuery) throws IOException, ParseException;
    /**
     * 添加一个新索引
     * @param commoditySpu
     * @throws IOException
     */
    public void addCommoditySpuIndex(CommoditySpu commoditySpu) throws IOException;
    /**
     * 通过id删除商品索引
     * @param id
     * @throws IOException
     */
    public void deleteCommoditySpuIndexById(String id) throws IOException;

}
