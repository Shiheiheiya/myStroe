package com.mystroe.service;

import com.mystroe.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取商品列表
     */
    List<Product> getProductList();
    List<Product> getProduct(String pid);
}
