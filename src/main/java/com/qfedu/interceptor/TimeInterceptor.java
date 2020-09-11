package com.qfedu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @className: TimeInterceptor
 * @package: com.qfedu.interceptor
 * @author: Stephen Shen
 * @date: 2020/9/11 上午9:32
 */
//看一下请求前，和渲染后中间间隔的时间差
public class TimeInterceptor implements HandlerInterceptor {

    long beginTTime;
    long endTTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("prehandle:");
        beginTTime = System.currentTimeMillis();
        Thread.sleep(5000);
        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
        endTTime= System.currentTimeMillis();
        System.out.println(endTTime);
        System.out.println("差："+(endTTime-beginTTime));
    }
}
