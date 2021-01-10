package com.mystore.web.service.impl;

import com.mystore.web.dao.ProductDao;
import com.mystore.web.pojo.Product;
import com.mystore.web.service.ProductService;

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
    public Product getProductByPid(String pid) {
        return productDao.getProductByPid(pid);
    }
}
