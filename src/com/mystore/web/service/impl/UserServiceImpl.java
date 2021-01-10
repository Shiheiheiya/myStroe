package com.mystore.web.service.impl;

import com.mystore.web.dao.UserDao;
import com.mystore.web.pojo.User;
import com.mystore.web.service.UserService;

import java.util.Arrays;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    public UserServiceImpl(){userDao = new UserDao();}
    @Override
    public int registerUser(User user, String[] hobbies) {
        //复选数据处理
        String hobby = Arrays.toString(hobbies);//[篮球,足球,乒乓球]
        //处理完复选数据后，重新赋值
        System.out.println(hobby);
        user.setHobby(hobby.substring(1, hobby.length()-1));
        //不重复的随机串获取 shagshaghs-ewtyetyw-dhsjhdjs-dhsjhdjs
        System.out.println("uuid length = " + UUID.randomUUID().toString());
        //去掉随机串中的 “-”
        user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
        return userDao.registerUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username , password);
    }

}
