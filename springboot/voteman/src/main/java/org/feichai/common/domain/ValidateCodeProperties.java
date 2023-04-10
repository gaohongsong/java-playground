package org.feichai.common.domain;

import lombok.Data;

@Data
public class ValidateCodeProperties {
    // 验证码图片宽度
    public static int width = 146;
    public static int height = 33;
    // 验证码位数
    public static int length = 4;
}
