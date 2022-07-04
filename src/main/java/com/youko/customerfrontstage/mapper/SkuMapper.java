package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface SkuMapper {
    CommoditySpu findOneSpu(int id);
    CommoditySpec findSpec(int id);
    List<CommoditySpecValue> findSV(int specID);
    List<CommoditySpuSpec> findSS(int spuID);
    List<CommoditySku> findSku(int spuID);
    /**
     * 寻找sku和规格的索引
     * @return
     */
    List<CommoditySkuSpecValue> findSSV(int skuID);

    List<CommoditySpu> findAllSpu();

}
