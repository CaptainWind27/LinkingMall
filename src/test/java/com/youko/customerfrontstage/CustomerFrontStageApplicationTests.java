package com.youko.customerfrontstage;

import com.youko.customerfrontstage.mapper.CustomerMapper;
import com.youko.customerfrontstage.service.CustomerService;
import com.youko.customerfrontstage.util.JaspyUtil;
import com.youko.customerfrontstage.util.YmlUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@MapperScan("com.youko.customerfrontstage.mapper")
@SpringBootTest
class CustomerFrontStageApplicationTests {
    @Autowired
    CustomerService customerService;

    @Test
    void contextLoads() {
        String pa = JaspyUtil.encryptWithMD5("12345");
       System.out.println(pa);
       System.out.println(JaspyUtil.decryptWithMD5(pa));
    }

}

