package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityMapper {

    /**
     * 查询库里的所有commodity
     * 用于之后的分页查询
     * @return 返回商品类的集合
     */
    List<Commodity> findAll();
}
