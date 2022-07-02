package com.youko.customerfrontstage.service.Lucene.impl;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.dao.ILuceneDao;
import com.youko.customerfrontstage.mapper.CommoditySpuMapper;
import com.youko.customerfrontstage.service.Lucene.ILuceneService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: youko
 * @classname: LuceneServiceImpl
 * @Description: some desc
 * @date: 2022/7/1 14:46
 */
@Service
public class LuceneServiceImpl implements ILuceneService {
    @Autowired
    private ILuceneDao luceneDao;
    @Autowired
    private CommoditySpuMapper commoditySpuMapper;


    @Override
    public void synCommoditySpuCreatIndex() throws IOException {
        // 获取所有的productList
        List<CommoditySpu> allCommoditySpu= commoditySpuMapper.getAllCommoditySpu();
        // 再插入productList
        luceneDao.createCommoditySpuIndex(allCommoditySpu);
    }

    @Override
    public PageQuery<CommoditySpu> searchCommoditySpu(PageQuery<CommoditySpu> pageQuery) throws IOException, ParseException {
        return luceneDao.searchCommoditySpu(pageQuery);
    }
}
