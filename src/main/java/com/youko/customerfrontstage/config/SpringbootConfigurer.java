package com.youko.customerfrontstage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class SpringbootConfigurer implements WebMvcConfigurer {
    //@Value可以将配置文件的内容自动注入到属性内
    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoPath;   //图标物理存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;   //图标映射路径

    /**
     *处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(ProfilePhotoMapperPath+"**").addResourceLocations("file:"+ProfilePhotoPath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


}
