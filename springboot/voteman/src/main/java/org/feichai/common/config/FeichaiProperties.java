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
    // 变量名需要和yaml中的key保持一致
    private ShiroProperties shiro = new ShiroProperties();
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();
    private String timeFormat = "yyyy-MM-dd HH:mm:ss";
    private boolean openAopLog = true;
}
