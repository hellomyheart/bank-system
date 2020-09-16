package com.qfedu.service;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;

/**
 * @description UserService
 * @className: UserService
 * @package: com.qfedu.service
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:45
 */
public interface UserService {
    public User login(String bankCode, String password);
    public void updateHeadImg(Integer id,String imagePath);
    public User selectByCode(String bankCode);
    public void updatePassword(String  bankCode, String oldPassword,String newPassword);
    public JsonResult insertUser(User user);
}
