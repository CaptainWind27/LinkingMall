package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.CommodityAttribution;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommodityAttrsMapper {
    CommodityAttribution findAll();
}
