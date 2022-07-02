package com.youko.customerfrontstage.service.Lucene;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageQuery;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

public interface ILuceneService {
    /**
     * 启动后将同步Product表,并创建index
     * @throws IOException
     */
    public void synCommoditySpuCreatIndex() throws IOException;

    public PageQuery<CommoditySpu> searchCommoditySpu(PageQuery<CommoditySpu> pageQuery) throws IOException, ParseException;

}
