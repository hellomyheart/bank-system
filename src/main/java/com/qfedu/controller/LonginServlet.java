package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description
 * @className: LonginServlet
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:55
 */

@WebServlet("/login.do")
public class LonginServlet extends HttpServlet {
    @Autowired
    private UserService userService;

    //TODO 后期修改
    @Override
    public void init(ServletConfig config)throws ServletException{
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bankCode = req.getParameter("bankCode");
        String password = req.getParameter("password");

        try {
            User user = userService.login(bankCode, password);
            //将User存到Session中
            req.getSession().setAttribute("loginUser",user);
            JsonUtils.writeJsonInfo(1,null,resp);
            //{code: 1,info:}
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.writeJsonInfo(0,e.getMessage(),resp);
        }
    }
}
