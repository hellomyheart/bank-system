package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @description
 * @className: LoginController
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/9 下午2:24
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String bankCode, String password, HttpSession session) {
        User user = userService.login(bankCode, password);
        session.setAttribute(StrUtils.LOGIN_USER, user);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }
}
