package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

/**
 * @description UserService实现类
 * @className: UserServiceImpl
 * @package: com.qfedu.service.impl
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:47
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String bankCode, String password) {
        User user = userDao.findByCode(bankCode);


        if (user == null) {
            throw new RuntimeException("账号错误");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return user;

    }
}
