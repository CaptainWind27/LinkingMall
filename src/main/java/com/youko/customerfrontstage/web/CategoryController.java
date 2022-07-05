package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.CommodityCategory;
import com.youko.customerfrontstage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CategoryController
 * @Description: 三级分类的控制层
 * @date: 2022/7/5 9:47
 */
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/user/page/category")
    public List<CommodityCategory> returnCategory(){
        return categoryService.getAll();
    }
}
