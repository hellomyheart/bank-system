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

    //线程安全存储变量
    private ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("prehandle:");
        //threadLocal存放变量值
        threadLocal.set(System.currentTimeMillis());
//        Thread.sleep(5000);
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
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        Long beginTime = threadLocal.get();
        System.out.println("差：" + (endTime - beginTime));
    }
}
