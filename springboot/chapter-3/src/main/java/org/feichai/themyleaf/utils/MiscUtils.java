package org.feichai.themyleaf.utils;

import org.springframework.util.AntPathMatcher;

public class MiscUtils {
    // Spring 框架提供的用于路径比较的类：路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    /**
     * @param requestURI 请求进来的url
     * @return 返回是否需要登录
     */
    public static boolean loginCheckFailed(String[] urls, String requestURI) {
        // 定义需要处理的请求路径

        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
