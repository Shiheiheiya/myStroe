package com.mystore.web.service;

import com.mystore.web.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取商品列表
     */
    List<Product> getProductList();

    /**
     * 通过Pid获取商品数据
     * @param pid
     * @return
     */
    Product getProductByPid(String pid);
}
