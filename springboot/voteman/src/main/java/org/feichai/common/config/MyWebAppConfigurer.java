package org.feichai.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.FileNotFoundException;

@Slf4j
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Value("${imagePath}")
    private String mImagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(mImagePath.equals("") || mImagePath.equals("${imagePath}")) {
            // String imagesPath = MyWebAppConfigurer.class.getClassLoader().getResource("").getPath();
            // if (imagesPath.indexOf(".jar") > 0) {
            //     imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            // } else {
            //     imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            // }
            //
            // imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images";
            // mImagePath = imagesPath;
            try {
                mImagePath = ResourceUtils.getURL("classpath:").getPath();
                mImagePath = mImagePath.substring(0, mImagePath.lastIndexOf("/")) + "/media";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        log.error("mImagePath: {}", mImagePath);
        registry.addResourceHandler("/images/**").addResourceLocations(mImagePath);
    }
}
