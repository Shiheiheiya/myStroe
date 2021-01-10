package com.mystore.web.service;

import com.mystore.web.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @param hobby
     * @return
     */
    int registerUser(User user , String[] hobby);
}
