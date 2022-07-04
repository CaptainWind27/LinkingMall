package com.youko.customerfrontstage.service;

import com.github.pagehelper.PageInfo;
import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.dto.commodity.MainPageSpuDto;
import com.youko.customerfrontstage.mapper.PictureMapper;
import com.youko.customerfrontstage.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    PictureMapper pictureMapper;

}
