package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.mapper.CommoditySpuMapper;
import com.youko.customerfrontstage.service.Lucene.ILuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author: youko
 * @classname: CommoditySpuSearchController
 * @Description: some desc
 * @date: 2022/7/1 15:55
 */
@RestController
public class CommoditySpuSearchController {
    @Autowired
    private ILuceneService service;
    @Autowired
    private CommoditySpuMapper commoditySpuMapper;



    @PostMapping("/search")
    public PageQuery<CommoditySpu> searchCommoditySpu(@RequestBody PageQuery<CommoditySpu> pageQuery) throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        PageQuery<CommoditySpu> pageQuery1=service.searchCommoditySpu(pageQuery);
        return pageQuery1;
    }

    /**
     * 测试查询所有商品
     * @return
     */
    @GetMapping("/selectAllSpu")
    public List<CommoditySpu> findAll(){
        return commoditySpuMapper.getAllCommoditySpu();
    }
}
