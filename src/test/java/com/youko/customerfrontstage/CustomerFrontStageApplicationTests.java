package com.youko.customerfrontstage;

import com.youko.customerfrontstage.dto.commodity.CommodityReturnDto;
import com.youko.customerfrontstage.mapper.CommodityMapper;
import com.youko.customerfrontstage.mapper.SkuMapper;
import com.youko.customerfrontstage.service.CommodityService;
import com.youko.customerfrontstage.service.CommoditySkuService;
import com.youko.customerfrontstage.web.CommoditySpuSkuController;
import com.youko.customerfrontstage.web.UserPageController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {

    @Autowired
    CommoditySkuService commoditySkuService;
    @Autowired
    CommoditySpuSkuController commoditySpuSkuController;
    @Test
    void contextLoads() {
        System.out.println(commoditySkuService.getSpecList(1));
    }

}

