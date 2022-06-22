package com.youko.customerfrontstage;

import com.youko.customerfrontstage.mapper.CustomerMapper;
import com.youko.customerfrontstage.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {
    @Autowired
    CustomerService customerService;

    @Test
    void contextLoads() {

    }

}
