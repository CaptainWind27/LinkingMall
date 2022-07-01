package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.dto.commodity.CommodityReturnDto;
import com.youko.customerfrontstage.dto.commodity.SpecValueDto;
import com.youko.customerfrontstage.service.CommoditySkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品的详情页，可以看到商品的详细参数和商品的评论
 * 还可以选择商品的不同规格
 */
@RestController
public class CommoditySpuSkuController {
    @Autowired
    CommoditySkuService commoditySkuService;
    @GetMapping ("/user/page/commoditySkus")
    public CommodityReturnDto returnSpuSku(@Param("commodityID") int commodityID){
        CommodityReturnDto commodityReturnDto = commoditySkuService.selectSpu(commodityID);
        commodityReturnDto.setSkuReturnDto(commoditySkuService.getReturnSku(commodityID));
        return commodityReturnDto;
    }
    @GetMapping("/user/page/getSpecAndValue")
    public List<SpecValueDto> getSpecValue(@Param("commodityID")int commodityID) {
        List<SpecValueDto> specValueDtos = commoditySkuService.getSpecValueOfSpu(commodityID);
        return  specValueDtos;
    }
}
