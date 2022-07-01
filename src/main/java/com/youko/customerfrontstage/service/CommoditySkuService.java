package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.*;
import com.youko.customerfrontstage.dto.commodity.CommodityReturnDto;
import com.youko.customerfrontstage.dto.commodity.SKUReturnDto;
import com.youko.customerfrontstage.dto.commodity.SpecOfSpu;
import com.youko.customerfrontstage.dto.commodity.SpecValueDto;
import com.youko.customerfrontstage.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommoditySkuService {
    @Autowired
    SkuMapper skuMapper;

    /**
     *
     * @param id:首页上点击的上商品的id
     * @return 返回给前端的封装对象，装有前端所需数据
     */
    public CommodityReturnDto selectSpu(int id) {
        CommodityReturnDto commodityReturnDto = new CommodityReturnDto();
        CommoditySpu spu = skuMapper.findOneSpu(id);
        List<CommoditySpuSpec> ss = skuMapper.findSS(id);
        List<CommoditySpec> cs = new ArrayList<>();
        for (CommoditySpuSpec s : ss) {
            cs.add(skuMapper.findSpec(s.getSpecID()));
        }
        List<List<CommoditySpecValue>> sv = new ArrayList<>();
        for (CommoditySpec c : cs) {
            int i = c.getId();
            List<CommoditySpecValue> sv1 = skuMapper.findSV(i);
            sv.add(sv1);
        }
        commodityReturnDto.setSpu(spu);
        commodityReturnDto.setSs(ss);
        commodityReturnDto.setCs(cs);
        commodityReturnDto.setSv(sv);
        return commodityReturnDto;
    }

    public List<SKUReturnDto> getReturnSku(int spuID){
        List<CommoditySku> skus = skuMapper.findSku(spuID);
        List<SKUReturnDto> skuReturnDtos = new ArrayList<>();
        for (CommoditySku commoditySku : skus) {
            int idOfSku = commoditySku.getId();
            List<CommoditySkuSpecValue> ssv = skuMapper.findSSV(idOfSku);
            SKUReturnDto skuReturnDto = new SKUReturnDto();
            skuReturnDto.setSku(commoditySku);
            skuReturnDto.setSsv(ssv);
            skuReturnDtos.add(skuReturnDto);
        }

        return skuReturnDtos;
    }

    public List<SpecValueDto> getSpecValueOfSpu(int spuID){
        List<CommoditySpuSpec> ss = skuMapper.findSS(spuID);
        List<CommoditySpec> cs = new ArrayList<>();
        for (CommoditySpuSpec s : ss) {
            cs.add(skuMapper.findSpec(s.getSpecID()));
        }
        List<SpecValueDto> specValueDtos =new ArrayList<>();
        for (CommoditySpec c : cs) {
            SpecValueDto specValueDto = new SpecValueDto();
            specValueDto.setSpec(c.getSpecName());
            List<CommoditySpecValue> sv = skuMapper.findSV(c.getId());
            List<String> valueList = new ArrayList<>();
            for (CommoditySpecValue commoditySpecValue : sv) {
                valueList.add(commoditySpecValue.getSpecValue());
            }
            specValueDto.setValues(valueList);
            specValueDtos.add(specValueDto);
        }
        return specValueDtos;
    }

    public List<SpecOfSpu> getSpecList(int spuID){
        List<SpecOfSpu> specValueDtos = new ArrayList<>();
        List<CommoditySpuSpec> ss = skuMapper.findSS(spuID);
        List<CommoditySpec> cs = new ArrayList<>();
        for (CommoditySpuSpec s : ss) {
            cs.add(skuMapper.findSpec(s.getSpecID()));
        }
        for (CommoditySpec c : cs) {
            SpecOfSpu specOfSpu = new SpecOfSpu();
            specOfSpu.setSpecID(c.getId());
            specOfSpu.setSpec(c.getSpecName());
            specValueDtos.add(specOfSpu);

        }

        return specValueDtos;
    }


}
