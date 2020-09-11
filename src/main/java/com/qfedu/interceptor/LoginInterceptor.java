package com.qfedu.interceptor;

import com.qfedu.entity.User;
import com.qfedu.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @className: LoginInterceptor
 * @package: com.qfedu.interceptor
 * @author: Stephen Shen
 * @date: 2020/9/11 上午10:48
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //uri 统一资源标识符
        //url 统一资源定位符

        User user = (User) request.getSession().getAttribute(StrUtils.LOGIN_USER);

        if (user == null) {
//            没有登录，直接跳转到login.html，非ajax请求
            //如果是ajax请求也得跳转到login.html
//如果是jQuery的ajax请求，会有一个jQuery请求头
            String value = request.getHeader("X_Requested-With");
            if (value != null && value.equals("XMLHttpRequest")) {
                response.getWriter().write("{\"code\":0,\"info\":\"未登录\"}");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }

            return false;
        }
        return true;
    }
}
