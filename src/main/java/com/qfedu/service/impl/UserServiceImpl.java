package com.qfedu.service.impl;

import com.qfedu.common.JsonResult;
import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @description UserService实现类
 * @className: UserServiceImpl
 * @package: com.qfedu.service.impl
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User login(String bankCode, String password) {
        User user = userDao.findByCode(bankCode);
        //加盐
        String slat = "stephenshen";

        String passwordMD5 = DigestUtils.md5DigestAsHex((password + slat).getBytes());


        if (user == null) {
            throw new RuntimeException("账号错误");
        }
        if (!user.getPassword().equals(passwordMD5)) {
            throw new RuntimeException("密码错误");
        }
        return user;
    }


    @Override
    public void updateHeadImg(Integer id, String imagePath) {

        User u = new User();
        u.setId(id);
        u.setImagePath(imagePath);
        userDao.update(u);

    }

    @Override
    public User selectByCode(String bankCode) {
        return userDao.findByCode(bankCode);
    }

    @Override
    public void updatePassword(String bankCode, String oldPassword, String newPassword) {

        //获取用户信息
        User user = userDao.findByCode(bankCode);

        //原密码比较

        //加盐
        String slat = "stephenshen";
        String oPassword = DigestUtils.md5DigestAsHex((oldPassword + slat).getBytes());
        if (!user.getPassword().equals(oPassword)){
            System.out.println(oPassword);
            throw new RuntimeException("原密码错误，请检查");
        }

        String nPassword = DigestUtils.md5DigestAsHex((newPassword + slat).getBytes());
        User user1 = new User();
        user1.setId(user.getId());
        user1.setPassword(nPassword);
        userDao.update(user1);

    }
}
