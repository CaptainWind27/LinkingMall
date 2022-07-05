package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.CommodityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CategoryMapper {
    /**
     * 寻找所有的分类
     * @return 返回分类的list
     */
    List<CommodityCategory> getAllCategory();
}
