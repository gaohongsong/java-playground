package org.feichai.common.domain;

import lombok.Data;

@Data
public class ValidateCodeProperties {
    // 验证码图片宽度
    public int width = 146;
    public int height = 33;
    // 验证码位数
    public int length = 4;
}
