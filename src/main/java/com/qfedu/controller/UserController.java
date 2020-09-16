package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

}
