package com.youko.customerfrontstage;

import com.github.pagehelper.PageInfo;
import com.youko.customerfrontstage.bean.Commodity;
import com.youko.customerfrontstage.mapper.CommodityMapper;
import com.youko.customerfrontstage.mapper.CustomerMapper;
import com.youko.customerfrontstage.service.CommodityService;
import com.youko.customerfrontstage.service.CustomerService;
import com.youko.customerfrontstage.util.JaspyUtil;
import com.youko.customerfrontstage.util.YmlUtils;
import com.youko.customerfrontstage.web.UserPageController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.method.P;

import java.util.List;
import java.util.Properties;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    UserPageController userPageController;
    @Autowired
    CommodityService commodityService;

    @Test
    void contextLoads() {
        userPageController.findPage(1,2);
    }

}

