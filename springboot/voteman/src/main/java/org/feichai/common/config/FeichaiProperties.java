package org.feichai.common.config;

import lombok.Data;
import org.feichai.common.domain.ValidateCodeProperties;
import org.feichai.common.shiro.ShiroProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "feichai")
public class FeichaiProperties {
    private ShiroProperties shiroProperties = new ShiroProperties();
    private ValidateCodeProperties validateCodeProperties = new ValidateCodeProperties();
    private String timeFormat = "yyyy-MM-dd HH:mm:ss";
    private boolean openAopLog = true;
}
