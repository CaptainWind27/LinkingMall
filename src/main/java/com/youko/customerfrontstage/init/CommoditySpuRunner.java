//package com.youko.customerfrontstage.init;
//
//import com.youko.customerfrontstage.service.Lucene.ILuceneService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
///**
// * @author: youko
// * @classname: CommoditySpuRunner
// * @Description: 项目启动后,立即执行
// * @date: 2022/7/1 12:15
// */
//@Component
//@Order(value = 1)
//public class CommoditySpuRunner implements ApplicationRunner {
//    @Autowired
//    private ILuceneService service;
//
//    @Override
//    public void run(ApplicationArguments arg0) throws Exception {
//        /**
//         * 启动后将同步Product表,并创建index
//         */
//        service.synCommoditySpuCreatIndex();
//    }
//}
