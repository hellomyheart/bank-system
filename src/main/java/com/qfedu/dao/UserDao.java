package com.qfedu.dao;

import com.qfedu.entity.User;

/**
 * @description
 * @className: UserDao
 * @package: com.qfedu.dao
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:29
 */
public interface UserDao {
    public User findByCode(String bankCode);
    public void update(User user);

}
