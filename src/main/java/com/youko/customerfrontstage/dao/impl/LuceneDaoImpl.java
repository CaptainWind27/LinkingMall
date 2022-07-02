package com.youko.customerfrontstage.dao.impl;

import com.youko.customerfrontstage.bean.CommoditySpu;
import com.youko.customerfrontstage.bean.PageInfo;
import com.youko.customerfrontstage.bean.PageQuery;
import com.youko.customerfrontstage.bean.Sort;
import com.youko.customerfrontstage.dao.ILuceneDao;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.lucene.search.BooleanQuery.Builder;
import org.apache.lucene.search.BooleanClause.Occur;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: youko
 * @classname: LuceneDaoImpl
 * @Description: some desc
 * @date: 2022/7/1 10:36
 */
@Repository(value = "luceneDao")
public class LuceneDaoImpl implements ILuceneDao {
    @Autowired(required = false)
    private IndexWriter indexWriter;

    @Autowired
    private Analyzer analyzer;

    @Autowired
    private SearcherManager searcherManager;

    @Override
    public void createCommoditySpuIndex(List<CommoditySpu> commoditySpuList)throws IOException{
        List<Document> docs=new ArrayList<Document>();
        for(CommoditySpu commoditySpu:commoditySpuList){
            Document doc=new Document();
            doc.add(new StringField("id",commoditySpu.getId()+"", Field.Store.YES));
            doc.add(new StringField("spuNo",commoditySpu.getSpuNo(),Field.Store.YES));
            doc.add(new TextField("goodsName",commoditySpu.getGoodsName(),Field.Store.YES));

            // 保存price,
            float lowPrice=commoditySpu.getLowPrice();
            //建立倒排索引
            doc.add(new FloatPoint("lowPrice",lowPrice));
            //正排序用于排序聚合
            doc.add(new FloatDocValuesField("lowPrice",lowPrice));
            //储存到索引库
            doc.add(new StoredField("lowPrice", lowPrice));

            doc.add(new StringField("categoryID",commoditySpu.getCategoryID()+"", Field.Store.YES));
            doc.add(new StringField("brandID",commoditySpu.getBrandID()+"", Field.Store.YES));
            docs.add(doc);
        }
        indexWriter.addDocuments(docs);
        indexWriter.commit();
    }

    @Override
    public PageQuery<CommoditySpu> searchCommoditySpu(PageQuery<CommoditySpu> pageQuery) throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher=searcherManager.acquire();
        CommoditySpu params = pageQuery.getParams();
        Map<String,String> queryParam=pageQuery.getQueryParam();
        Builder builder=new BooleanQuery.Builder();
        org.apache.lucene.search.Sort sort=new org.apache.lucene.search.Sort();
        //排序规则
        Sort sort1=pageQuery.getSort();
        if(sort1!=null&&sort1.getOrder()!=null){
            if("ASC".equals((sort1.getOrder()).toUpperCase())){
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, false));
            } else if ("DESC".equals((sort1.getOrder()).toUpperCase())) {
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, true));
            }
        }

        // 模糊匹配,匹配词
        String keyStr = queryParam.get("searchKeyStr");
        if (keyStr != null) {
            // 输入空格,不进行模糊查询
            if (!"".equals(keyStr.replaceAll(" ", ""))) {
                builder.add(new QueryParser("goodsName", analyzer).parse(keyStr), Occur.MUST);
            }
        }

//        // 精确查询
//        if (!"".equals(params.getCategoryID()+"")) {
//            builder.add(new TermQuery(new Term("category", params.getCategoryID()+"")), Occur.MUST);
//        }
        if (queryParam.get("lowerPrice") != null && queryParam.get("upperPrice") != null) {
            // 价格范围查询
            builder.add(FloatPoint.newRangeQuery("lowPrice", Float.parseFloat(queryParam.get("lowerPrice")),
                    Float.parseFloat(queryParam.get("upperPrice"))), Occur.MUST);
        }
        PageInfo pageInfo = pageQuery.getPageInfo();
        TopDocs topDocs = indexSearcher.search(builder.build(), pageInfo.getPageNum() * pageInfo.getPageSize(), sort);

        pageInfo.setTotal(topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;
        List<CommoditySpu> pList = new ArrayList<CommoditySpu>();
        for (int i = 0; i < hits.length; i++) {
            Document doc = indexSearcher.doc(hits[i].doc);
            System.out.println(doc.toString());
            CommoditySpu commoditySpu = new CommoditySpu();

            commoditySpu.setId(Integer.parseInt(doc.get("id")));
            commoditySpu.setSpuNo(doc.get("spuNo"));
            commoditySpu.setGoodsName(doc.get("goodsName"));
            commoditySpu.setLowPrice(Float.parseFloat(doc.get("lowPrice")));
            commoditySpu.setCategoryID(Integer.parseInt(doc.get("categoryID")));
            commoditySpu.setBrandID(Integer.parseInt(doc.get("brandID")));
            pList.add(commoditySpu);
        }
        pageQuery.setResults(pList);
        return pageQuery;
    }

    @Override
    public void addCommoditySpuIndex(CommoditySpu commoditySpu) throws IOException {
        Document doc = new Document();
        doc.add(new StringField("id", commoditySpu.getId()+"", Field.Store.YES));
        doc.add(new StringField("spuNo",commoditySpu.getSpuNo(),Field.Store.YES));
        doc.add(new TextField("goodsName",commoditySpu.getGoodsName(),Field.Store.YES));

        //建立倒排索引
        doc.add(new FloatPoint("lowPrice",commoditySpu.getLowPrice()));
        //正排序用于排序聚合
        doc.add(new FloatDocValuesField("lowPrice",commoditySpu.getLowPrice()));

        doc.add(new StringField("categoryID",commoditySpu.getCategoryID()+"", Field.Store.YES));
        doc.add(new StringField("brandID",commoditySpu.getBrandID()+"", Field.Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.commit();
    }


    @Override
    public void deleteCommoditySpuIndexById(String id)throws IOException {
        indexWriter.deleteDocuments(new Term("id", id));
        indexWriter.commit();
    }

}
