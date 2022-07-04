package com.youko.customerfrontstage;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageInfo;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.bean.Sort;
import com.youko.customerfrontstage.dao.ILuceneDao;
import com.youko.customerfrontstage.dao.impl.LuceneDaoImpl;
import com.youko.customerfrontstage.dto.commodity.CommodityReturnDto;
import com.youko.customerfrontstage.mapper.CommodityMapper;
import com.youko.customerfrontstage.mapper.PictureMapper;
import com.youko.customerfrontstage.mapper.SkuMapper;
import com.youko.customerfrontstage.service.CommodityService;
import com.youko.customerfrontstage.service.CommoditySkuService;
import com.youko.customerfrontstage.service.PictureService;
import com.youko.customerfrontstage.web.CommoditySpuSkuController;
import com.youko.customerfrontstage.web.UserPageController;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {

    @Autowired
    PictureService pictureService;

    @Test
    void contextLoads() throws IOException, ParseException {
//        PageInfo pageInfo=new PageInfo();
//        pageInfo.setPageNum(1);
//        pageInfo.setPageSize(2);
//        Sort sort=new Sort();
//        sort.setField("lowPrice");
//        sort.setOrder("asc");
//        CommoditySpu commoditySpu=new CommoditySpu();
//        Map<String,String> queryParam=new HashMap<String,String>();
//        queryParam.put("searchKeyStr","小米");
//        PageQuery<CommoditySpu> pageQuery=new PageQuery<CommoditySpu>();
//
//
//        pageQuery.setPageInfo(pageInfo);
//        pageQuery.setSort(sort);
//        pageQuery.setQueryParam(queryParam);
//        pageQuery.setParams(commoditySpu);
//        System.out.println(luceneDao.searchCommoditySpu(pageQuery));

    }

}

