package com.onyx.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String userName;

    @GetMapping("/getConfig")
    public String getConfig() {
        return "当前配置：url=" + url + "， username=" + userName;
    }
}
