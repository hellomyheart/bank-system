package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description
 * @className: UserController
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/9 下午2:33
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    /**
     *     查询用户信息
     * @param session
     * @return
     */
    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult getLoginInfo(HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);

        //重新查询一遍
        user = userService.selectByCode(user.getBankCode());

        JsonResult jsonResult = null;
        if (user != null) {
            jsonResult = new JsonResult(1, user);
        } else {
            jsonResult= new JsonResult(0,"用户未登录");
        }

        return jsonResult;
    }


    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping("/changepassword.do")
    @ResponseBody
    public JsonResult changePassword(String oldPassword,String newPassword,HttpSession session) {


        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        userService.updatePassword(user.getBankCode(),oldPassword,newPassword);

        JsonResult jsonResult = new JsonResult(1, "修改成功");
        return jsonResult;

    }

    /**
     * 退出登录
     * @param session
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/logout.do")
    @ResponseBody
    public void logOut(HttpSession session, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {

        //清除session
        session.removeAttribute(StrUtils.LOGIN_USER);

        //转发到登录页面有问题，比较特殊，其他静态资源无法获取
//        httpServletRequest.getRequestDispatcher("/login.html").forward(httpServletRequest,httpServletResponse);
        //重定向没有问题
        httpServletResponse.sendRedirect("/login.html");
    }


    /**
     * 注册账号
     * @param bankCode
     * @param password
     * @return
     */
    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult register( String bankCode,String password) {

        User user = new User();
        user.setBankCode(bankCode);
        user.setPassword(password);

        return userService.insertUser(user);


    }

}
