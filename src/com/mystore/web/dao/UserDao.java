package com.mystore.web.dao;

import com.mystore.web.pojo.User;
import com.mystore.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDao {
    private static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

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
}
