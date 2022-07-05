package com.youko.customerfrontstage;

import com.youko.customerfrontstage.mapper.CategoryMapper;
import com.youko.customerfrontstage.service.CategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ServiceTest {
    @Autowired
    CategoryService categoryService;
    @Test
    public void test(){
        System.out.println(categoryService.getAll().toString());
    }
}
