package com.example.lt.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Value("${image.save.path}")
    String absoluteImgPath;

    @Value("${image.sonImgPath}")
    String sonImgPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/web/images/");
        registry.addResourceHandler(sonImgPath + "**").addResourceLocations("file:"+absoluteImgPath);
    }
}
