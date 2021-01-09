package com.mystroe.service.impl;

import com.mystroe.dao.ProductDao;
import com.mystroe.pojo.Product;
import com.mystroe.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;
    public ProductServiceImpl() {
        this.productDao = new ProductDao();
    }

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public List<Product> getProduct(String pid) {
        return productDao.getProduct(pid);
    }
}
