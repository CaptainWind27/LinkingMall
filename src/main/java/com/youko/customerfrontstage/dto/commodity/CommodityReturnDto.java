package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class CommodityReturnDto implements Serializable {
    private static final long serialVersionUID = 2922574610899707684L;
    List<SKUReturnDto> skuReturnDto;
    CommoditySpu spu;
    List<CommoditySpec> cs;
    List<CommoditySpuSpec> ss;
    List<List<CommoditySpecValue>> sv;
}
