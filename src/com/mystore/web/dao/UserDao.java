package com.mystore.web.dao;

import com.mystore.web.pojo.User;
import com.mystore.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public int registerUser(User user){
        try {
            String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
            int rows = qr.update(sql , user.getUid(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getName(),
                    user.getHobby(),
                    user.getEmail(),
                    user.getTelephone(),
                    user.getBirthday(),
                    user.getSex(),0,0);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        try {
            String sql = "select u.name from user u where u.username = ? and u.password = ? and u.is_delete != 1";
            User user = qr.query(sql, new BeanHandler<>(User.class), username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
