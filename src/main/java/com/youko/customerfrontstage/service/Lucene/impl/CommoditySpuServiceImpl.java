package com.youko.customerfrontstage.service.Lucene.impl;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.dao.ILuceneDao;
import com.youko.customerfrontstage.mapper.CommoditySpuMapper;
import com.youko.customerfrontstage.service.Lucene.ICommoditySpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: youko
 * @classname: CommoditySpuServiceImpl
 * @Description: some desc
 * @date: 2022/7/1 15:28
 */
@Service
public class CommoditySpuServiceImpl implements ICommoditySpuService {

    @Autowired
    private CommoditySpuMapper commoditySpuMapper;
    @Autowired
    private ILuceneDao luceneDao;

    @Override
    public CommoditySpu getCommoditySpuById(String id) {
        return commoditySpuMapper.getCommoditySpuById(id);
    }

    @Override
    public List<CommoditySpu> getAllCommoditySpu() {
        return commoditySpuMapper.getAllCommoditySpu();
    }

    @Override
    public List<CommoditySpu> getCommoditySpuList(PageQuery<CommoditySpu> pageQuery) {
        return commoditySpuMapper.getCommoditySpuList(pageQuery);
    }

    @Override
    public void addCommoditySpu(CommoditySpu commoditySpu) throws IOException {
        commoditySpuMapper.addCommoditySpu(commoditySpu);
        //添加索引
        luceneDao.addCommoditySpuIndex(commoditySpu);
    }

    @Override
    public void deleteCommoditySpuById(String id) throws IOException {
        commoditySpuMapper.deleteCommoditySpuById(id);
        //删除索引
        luceneDao.deleteCommoditySpuIndexById(id);
    }

    @Override
    public void updateCommoditySpuById(CommoditySpu commoditySpu) throws IOException {
        commoditySpuMapper.updateCommoditySPuById(commoditySpu);
        //更新索引,先删除,在插入
        luceneDao.deleteCommoditySpuIndexById(commoditySpu.getId()+"");
        luceneDao.addCommoditySpuIndex(commoditySpu);
    }
}
