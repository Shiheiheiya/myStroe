package com.mystore.admin.service;

import com.mystore.admin.pojo.Product;
import com.mystore.admin.vo.Condition;

import java.util.List;

public interface ProductService {
    /**
     * 获取全部商品信息
     * @return
     */
    List<Product> getProductList();

    /**
     * 根据pid删除商品
     * @param pid
     * @return
     */
    int deleteProductByPid(String pid);

    /**
     * 添加商品
     * @param product
     * @return
     */
    int saveProduct(Product product);

    /**
     * 根据pid获取商品信息
     * @param pid
     * @return
     */
    Product getProductByPid(String pid);

    /**
     * 更新商品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 根据筛选条件查询商品列表
     * @param condition
     * @return
     */
    List<Product> getProductListByCondition(Condition condition);
}
