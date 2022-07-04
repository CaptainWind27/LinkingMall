package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.CommoditySpu;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainPageSpuDto implements Serializable {
    CommoditySpu spu;
    String picPath;
}
