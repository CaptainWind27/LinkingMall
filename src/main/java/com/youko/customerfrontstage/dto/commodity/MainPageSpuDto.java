package com.youko.customerfrontstage.dto.commodity;

import com.youko.customerfrontstage.bean.CommoditySpu;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainPageSpuDto implements Serializable {
    private static final long serialVersionUID = 1149153702720419418L;
    CommoditySpu spu;
    String picPath;
}
