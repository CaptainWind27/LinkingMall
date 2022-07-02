package com.youko.customerfrontstage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youko.customerfrontstage.bean.Commodity;
import com.youko.customerfrontstage.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * commodity的service层
 */
@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    /**
     * ，负责实现分页算法，调用mapper中的findall()方法
     * @param pageNum 页的开始位
     * @param pageSize 页的大小
     * @return 商品的集合
     */
    public List<Commodity> findByPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities= commodityMapper.findAll();
        PageInfo<Commodity> commodityPageInfo = new PageInfo<>(commodities);
        return commodityPageInfo.getList();
    }

    public Commodity selectById(int id){
        return commodityMapper.findCommodityById(id);
    }

    public List<Commodity> selectAll(){
        return commodityMapper.findAll();
    }

}
