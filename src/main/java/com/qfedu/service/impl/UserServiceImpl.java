package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        if (user == null) {
            throw new RuntimeException("账号错误");
        }
        if (!user.getPassword().equals(password)) {
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
}
