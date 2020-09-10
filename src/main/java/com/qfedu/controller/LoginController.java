package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.aspectj.bridge.IMessage;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;
import java.util.Iterator;

/**
 * @description
 * @className: LoginController
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/9 下午2:24
 */
@Controller
//如果在方法参数上使用验证注解，赢要在这个类上写这个注解@Validated
@Validated
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(@NotEmpty(message = "{name.empty}") String bankCode, @Size(min = 1,max = 10) String password, HttpSession session) {
        User user = userService.login(bankCode, password);
        session.setAttribute(StrUtils.LOGIN_USER, user);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }


}
