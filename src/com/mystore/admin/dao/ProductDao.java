package com.mystore.admin.dao;

import com.mystore.admin.pojo.Product;
import com.mystore.admin.util.C3p0Util;
import com.mystore.admin.vo.Condition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao {
    private  static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Util.getDataSource());
    }

    /**
     * 访问数据库获取商品列表
     * @return
     */
    public List<Product> getProductList() {

        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage from product p where p.is_delete != 1 order by p.pdate desc";
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            System.out.println("----" + productList.size());
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public int deleteProductByPid(String pid) {
        try {
            String sql = "update product set is_delete = 1 where pid = ?";
            int rows = qr.update(sql , pid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int saveProduct(Product product) {
        String sql = "insert into product values (?,?,?,?,now(),?,?,?,?,?,?)";
        try {
            int rows = qr.update(sql,
                    product.getPid(),
                    product.getPname(),
                    product.getMarketPrice(),
                    product.getShopPrice(),
                    product.getPimage(),
                    product.getIsHot(),
                    product.getPdesc(),
                    product.getPflag(),
                    product.getCid(),
                    product.getIsDelete());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Product getProductByPid(String pid) {
        try {
            String sql = "select " +
                    "p.pname , " +
                    "p.pid , " +
                    "p.market_price as marketPrice , " +
                    "p.shop_price as shopPrice , " +
                    "p.is_hot as isHot," +
                    "p.pimage," +
                    "p.pdesc," +
                    "p.cid from product p where p.is_delete != 1 and pid = ?";
            Product product = qr.query(sql , new BeanHandler<>(Product.class),pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateProduct(Product product) {
        try {
            String sql = "update product set pname = ? , " +
                    "market_price = ? , " +
                    "shop_price = ? ," +
                    "is_hot = ? , " +
                    "pdesc = ? , " +
                    "cid = ? where " +
                    "pid = ?";
            int rows = qr.update(sql, product.getPname(),
                    product.getMarketPrice(),
                    product.getShopPrice(),
                    product.getIsHot(),
                    product.getPdesc(),
                    product.getCid(),
                    product.getPid());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> getProductListByCondition(Condition condition) {

        String sql = "select " +
                "p.pname , " +
                "p.pid , " +
                "p.market_price as marketPrice , " +
                "p.shop_price as shopPrice , " +
                "p.is_hot as isHot," +
                "p.pimage," +
                "p.pdesc," +
                "p.cid from product p where p.is_delete != 1 ";
        List<Object> list = new ArrayList<>();
        if(null != condition.getPname() && !condition.getPname().equals("")){
            //like '%小' : 以小结束的字符串  like '小%' : 以小开头的  like '%小%' : 包含小的
            sql += " and p.pname like ? ";

            list.add("%"+condition.getPname()+"%");
        }
        if(condition.getIsHot() != -1){
            sql += " and p.is_hot = ? ";
            list.add(condition.getIsHot());
        }
        if(null != condition.getCid() && !condition.getCid().equals("")){
            sql += " and p.cid = ? ";
            list.add(condition.getCid());
        }
        try {
            List<Product> productList = qr.query(sql,new BeanListHandler<>(Product.class), list.toArray());//可变参数就是数组
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
