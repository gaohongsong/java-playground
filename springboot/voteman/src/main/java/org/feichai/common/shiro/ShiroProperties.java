package org.feichai.common.shiro;

import lombok.Data;

@Data
public class ShiroProperties {
    // redis 缓存时长，默认1800s
    private int expireIn = 1800;
    // session超时时间，默认1800000s
    private long sessionTimeout = 1800000L;
    // rememberMe 有效时长，默认86400s，1天
    private int cookieTimeout = 86400;

    private static String loginUrl = "/login";
    private static String successUrl = "/index";
    private static String logoutUrl = "/logout";
    private static String unauthorizedUrl;
}
