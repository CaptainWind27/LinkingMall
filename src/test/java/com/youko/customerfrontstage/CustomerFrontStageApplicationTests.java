package com.youko.customerfrontstage;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {

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

