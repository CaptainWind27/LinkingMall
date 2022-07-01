package com.youko.customerfrontstage.service.Lucene;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;

import java.io.IOException;
import java.util.List;

/**
 * 商品服务接口
 * @author yizl
 *
 */
public interface ICommoditySpuService {
    /**
     * 通过id获取商品详情
     * @param id
     * @return
     */
    public CommoditySpu getCommoditySpuById(String id);
    /**
     * 获取所有商品
     * @return
     */
    public List<CommoditySpu> getAllCommoditySpu();

    /**
     * 通过参数查询
     * @param pageQuery 分页查询参数
     * @return
     */
    public List<CommoditySpu> getCommoditySpuList(PageQuery<CommoditySpu> pageQuery);
    /**
     * 添加商品
     * @param commoditySpu
     * @throws IOException
     */
    public void addCommoditySpu(CommoditySpu commoditySpu) throws IOException;
    /**
     * 根据id删除商品
     * @param id
     * @throws IOException
     */
    public void deleteCommoditySpuById(String id) throws IOException;
    /**
     * 更新商品信息
     * @param commoditySpu
     * @throws IOException
     */
    public void updateCommoditySpuById(CommoditySpu commoditySpu) throws IOException;

}
