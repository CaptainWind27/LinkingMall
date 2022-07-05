package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.CommodityCategory;
import com.youko.customerfrontstage.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public List<CommodityCategory> getAll(){
        return categoryMapper.getAllCategory();
    }
}
