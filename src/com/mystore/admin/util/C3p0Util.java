package com.mystore.admin.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3p0数据库连接池 -- 市场占有率极高  60%
 * 可以设计最大/最小的链接数量 、连接等待时间（超时时间）
 * 此连接池持续运行稳定性很好、在大量并发时(多线程下) 稳定性也有一定的保障。
 */
public class C3p0Util {

    private static ComboPooledDataSource dataSource;//声明数据源

    static {
        //推荐使用配置文件方式
        dataSource = new ComboPooledDataSource();//默认去src下查找一个名字叫c3p0-config.xml
    }
    /**
     * 从连接池获取连接
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取数据源
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
