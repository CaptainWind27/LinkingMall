package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.CommoditySpecValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpecValueDto implements Serializable {
    List<SpecOfSpu> specOfSpu;
    List<CommoditySpecValue> specValues;
}
