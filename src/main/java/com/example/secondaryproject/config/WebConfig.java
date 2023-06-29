package com.example.secondaryproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${goodsPic.localPath}")
    String goodsLocalPath;
    @Value("${goodsPic.accessPath}")
    String goodsAccessPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(goodsAccessPath).addResourceLocations("file:"+goodsLocalPath);
    }
}
