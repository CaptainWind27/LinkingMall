package com.youko.customerfrontstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.youko.customerfrontstage.mapper")
public class CustomerFrontStageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontStageApplication.class, args);
    }

}
