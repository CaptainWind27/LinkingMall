package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CommodityReturnDto {
    List<SKUReturnDto> skuReturnDto;
    CommoditySpu spu;
    List<CommoditySpec> cs;
    List<CommoditySpuSpec> ss;
    List<List<CommoditySpecValue>> sv;
}
