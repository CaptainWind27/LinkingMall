//package com.youko.customerfrontstage;
//
//import com.youko.customerfrontstage.bean.Commodity;
//import com.youko.customerfrontstage.mapper.CommodityMapper;
//import com.youko.customerfrontstage.service.CommodityService;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.document.*;
//import org.apache.lucene.index.*;
//import org.apache.lucene.search.*;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//import org.apache.lucene.util.Version;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.wltea.analyzer.lucene.IKAnalyzer;
//
//import java.io.File;
//import java.util.List;
//
///**
// * @author: youko
// * @classname: LuceneDemoApplicationTests
// * @Description: some desc
// * @date: 2022/6/30 16:52
// */
//@SpringBootTest
//public class LuceneDemoApplicationTests {
//    @Autowired
//    private CommodityMapper commodityMapper;
//
//    @Autowired
//    private CommodityService commodityService;
//
//    @Test
//    public void createIndex()throws Exception{
//        //1.指定索引文件的存储位置，索引具体的表现形式就是一组有规则的文件
//        Directory directory = FSDirectory.open(new File("E:\\Code\\JavaProject\\Lucene"));
//        //2.配置版本及其分词器
////        Analyzer analyzer = new StandardAnalyzer();
//        Analyzer analyzer = new IKAnalyzer();
//        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
//        //3.创建IndexWriter对象，作用就是创建索引
//        IndexWriter indexWriter = new IndexWriter(directory, config);
//        //先删除已经存在的索引库
//        indexWriter.deleteAll();
//        //4.获取索引源(原始数据)
//        List<Commodity> commodities = commodityService.selectAll();
//        //5.遍历jobInfoList，每次遍历创建一个Document对象
//        for (Commodity commodity : commodities) {
//            //创建Document对象
//            Document document = new Document();
//            //创建Field对象
//            document.add(new IntField("id", commodity.getId(), Field.Store.YES));
//            //切分词、索引、存储
//            document.add(new TextField("name", commodity.getName(), Field.Store.YES));
//
////            document.add(new TextField("companyAddr", jobInfo.getCompanyName(), Field.Store.YES));
////            document.add(new TextField("companyInfo", jobInfo.getCompanyName(), Field.Store.YES));
////            document.add(new TextField("jobName", jobInfo.getCompanyName(), Field.Store.YES));
////            document.add(new TextField("jobAddr", jobInfo.getCompanyName(), Field.Store.YES));
////            document.add(new TextField("jobInfo", jobInfo.getCompanyName(), Field.Store.YES));
////            document.add(new IntField("salaryMin", jobInfo.getSalaryMin(), Field.Store.YES));
////            document.add(new IntField("salaryMax", jobInfo.getSalaryMax(), Field.Store.YES));
////            document.add(new StringField("url", jobInfo.getUrl(), Field.Store.YES));
////            document.add(new StringField("time", jobInfo.getTime(), Field.Store.YES));
//
//            //将文档追加到索引库中
//            indexWriter.addDocument(document);
//        }
//        indexWriter.close();
//        System.out.println("create index success");
//
//
//    }
//
//    /**
//     * 查询索引
//     */
//    @Test
//    public void query() throws Exception {
//        //1.指定索引文件的存储位置，索引具体的表现形式就是一组有规则的文件
//        Directory directory = FSDirectory.open(new File("E:\\Code\\JavaProject\\Lucene"));
//        //2.IndexReader对象
//        IndexReader indexReader = DirectoryReader.open(directory);
//        //3.创建查询对象，IndexSearcher
//        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
//
//        //4.使用term查询 ,查询公司名称中包含“北京”的所有的文档对象
//        Query query = new TermQuery(new Term("name", "英寸"));
//        TopDocs topDocs = indexSearcher.search(query, 100);
//        //获得符合条件查询的文档数
//        int totalHits = topDocs.totalHits;
//        System.out.println("符合条件的文档数：" + totalHits);
//        //获得命中的文档 ScoreDoc 封装了文档id信息
//        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
//        for (ScoreDoc scoreDoc : scoreDocs) {
//            //文档id
//            int docId = scoreDoc.doc;
//            //通过文档id获取文档对象
//            Document doc = indexSearcher.doc(docId);
//            System.out.println("id-->" + doc.get("id"));
//            System.out.println("name-->" + doc.get("name"));
//            System.out.println("****************************");
//        }
//        indexReader.close();
//    }
//}
