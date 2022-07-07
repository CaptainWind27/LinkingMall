package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.CommoditySpecValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpecValueDto implements Serializable {
    private static final long serialVersionUID = -4616462451031142568L;
    List<SpecOfSpu> specOfSpu;
    List<CommoditySpecValue> specValues;
}
