package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommoditySpuMapper {
    /**
     * 通过id获取商品
     * @param id
     * @return
     */
    public CommoditySpu getCommoditySpuById(String id);

    /**
     * 获取所有的商品
     * @return
     */
    public List<CommoditySpu> getAllCommoditySpu();

    /**
     * 通过参数查询,筛选商品
     * @param pageQuery
     * @return
     */
    public List<CommoditySpu> getCommoditySpuList(PageQuery<CommoditySpu> pageQuery);

    /**
     * 添加商品
     * @param commoditySpu
     */
    public void addCommoditySpu(CommoditySpu commoditySpu);
    /**
     * 通过id删除商品
     * @param id
     */
    public void deleteCommoditySpuById(String id);
    /**
     * 更新商品
     * @param commoditySpu
     */
    public void updateCommoditySPuById(CommoditySpu commoditySpu);


}
