package com.youko.customerfrontstage.web;

import com.github.pagehelper.PageInfo;
import com.youko.customerfrontstage.bean.Commodity;
import com.youko.customerfrontstage.bean.Page;
import com.youko.customerfrontstage.dto.commodity.CommodityReturnDto;
import com.youko.customerfrontstage.service.CommodityService;
import com.youko.customerfrontstage.service.CommoditySkuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * commodity商品类的管理层
 * 负责加载主页面，并且将商品库里的数据传给前端
 */
@RestController
public class UserPageController {
    @Autowired
    CommodityService commodityService;

    /**
     * 当进入主页即会调用的函数，主页实现分页的函数
     * @param pageNum 当前页
     * @param pageSize 每页的大小
     * @return Page的对象包含当前页，页大小，和
     */
    @GetMapping("/user/page")
    public Page<Commodity> findPage(@Param("pageNum") int pageNum, @Param("pageSize")int pageSize) {
        List<Commodity> commodities= commodityService.findByPage(pageNum,pageSize);
        //这个是pagehelper提供的功能，能够快速的查询page，使用pageinfo
        PageInfo<Commodity> commodityPageInfo = new PageInfo<>(commodities);
        Page<Commodity> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setDayaList(commodityPageInfo.getList());
        return page;
    }

}
