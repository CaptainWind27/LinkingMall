//package com.youko.customerfrontstage.config;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class PicPathWebMvcConfig implements WebMvcConfigurer {
//    private String filePath = "D:webPicture";
//    @Value("${prop.upload-folder}")
//    private String UPLOAD_FOLDER;
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/web_img/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/resources/static/web_img/");
//
//    }
//}
