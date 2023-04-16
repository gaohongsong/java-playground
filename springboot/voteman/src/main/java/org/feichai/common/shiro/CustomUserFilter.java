package org.feichai.common.shiro;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.feichai.common.domain.ResponseBo;
import org.feichai.common.util.HttpUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUserFilter extends UserFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (HttpUtils.isAjaxRequest((HttpServletRequest) request)) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletResponse.getWriter().println(JSON.toJSON(ResponseBo.error()));
        } else {
            saveRequestAndRedirectToLogin(request, response);
        }

        return false;
    }
}
