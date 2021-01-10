package com.mystore.web.dao;

import com.mystore.web.pojo.Product;
import com.mystore.web.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    /**
     * 通过Pid访问数据库获取商品信息
     * @param pid
     * @return
     */
    public Product getProductByPid(String pid){
        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot , " +
                    "p.pimage ," +
                    "p.pdesc from product p " +
                    "where p.pid = ?";
            Product product = qr.query(sql, new BeanHandler<>(Product.class), pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
