package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @description
 * @className: UploadController
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/10 下午3:31
 */
@Controller
public class UploadController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadFile(@RequestParam MultipartFile upfile, HttpSession session) {
        User u = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (u == null) {
            return new JsonResult(0, "未登录");
        }
        //0.把文件写到本地磁盘，刚好对应虚拟路径 /media/syj/docs/Code/idea/upload
        //1.上传文件目录
        String dir = "/media/syj/docs/Code/idea/upload";

        //2.获取文件名
        String filename = upfile.getOriginalFilename();
        System.out.println(filename);

        //3.判断上传文件目录是否存在
        File dirFile = new File(dir);

        if (!dirFile.exists()) {
            //没有则创建
            dirFile.mkdirs();
        }

        //4.要把上传的文件保存成一个对象

        File newFile = new File(dir, filename);


        //5.保存文件

        try {
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //操作数据库
        userService.updateHeadImg(u.getId(),"/upload/"+filename);

        return new JsonResult(1, "上传成功");
    }



}
