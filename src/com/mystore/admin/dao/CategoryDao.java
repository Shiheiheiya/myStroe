package com.mystore.admin.dao;

import com.mystore.admin.pojo.Category;
import com.mystore.admin.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryDao {

    private  static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }
    public List<Category> getCategoryList() {
        try {
            List<Category> categoryList = qr.query("select * from category" , new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
