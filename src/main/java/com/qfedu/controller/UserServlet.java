package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description
 * @className: UserServlet
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/4 上午11:13
 */
@WebServlet("/user/query.do")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("loginUser");

        if (user != null) {
            JsonUtils.writeJsonInfo(1,user.getBankCode(),resp);
        }else {
            JsonUtils.writeJsonInfo(0,null,resp);
        }
    }
}
