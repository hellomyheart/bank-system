package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @description
 * @className: UserDaoImpl
 * @package: com.qfedu.dao.impl
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:37
 */
public class UserDaoImpl implements UserDao {


    @Override
    public User findByCode(String bankCode) {
        SqlSession session = MyBatisUtil.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.findByCode(bankCode);
        return user;
    }
}
