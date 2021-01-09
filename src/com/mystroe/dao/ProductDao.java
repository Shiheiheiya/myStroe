package com.mystroe.dao;

import com.mystroe.pojo.Product;
import com.mystroe.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * 数据库dao层 - 商品列表数据
 */
public class ProductDao{
    /**
     * 获取数据库源
     */
    private static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }
    /**
     * 访问数据库获取商品列表
     */
    public List<Product> getProductList(){
        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage from product p";
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Product> getProduct(String pid){
        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot , " +
                    "p.pimage from product p " +
                    "where p.pid = " + pid;
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
