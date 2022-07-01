package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.service.Lucene.ILuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author: youko
 * @classname: CommoditySpuSearchController
 * @Description: some desc
 * @date: 2022/7/1 15:55
 */
@RestController
@RequestMapping("/commoditySpu/search")
public class CommoditySpuSearchController {
    @Autowired
    private ILuceneService service;



    @PostMapping("/searchCommodity")
    private PageQuery<CommoditySpu> searchCommoditySpu(@RequestBody PageQuery<CommoditySpu> pageQuery) throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        PageQuery<CommoditySpu> pageQuery1=service.searchCommoditySpu(pageQuery);
        return pageQuery1;
    }
}
