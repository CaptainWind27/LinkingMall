package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.CommoditySku;
import com.youko.customerfrontstage.bean.CommoditySkuSpecValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class SKUReturnDto implements Serializable {
    private static final long serialVersionUID = 8779206777017011284L;
    CommoditySku sku;
    List<CommoditySkuSpecValue> ssv;
}
