package com.mystore.web.service.impl;

import com.mystore.web.dao.ProductDao;
import com.mystore.web.pojo.Product;
import com.mystore.web.service.ProductService;
import com.mystore.web.vo.Page;

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
    @Override
    public Page getPageByCurrentPageAndMaxCount(String currentPage, int maxCount) {
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxCount(maxCount);
        page.setTotalCount(productDao.getProductTotalCount());
        //(currentPage - 1) * maxCount
        page.setCurrentIndex((Integer.valueOf(currentPage) - 1) * maxCount);
        page.setProductList(productDao.getProductListByIndexAndMaxCount(page.getCurrentIndex() , page.getMaxCount()));

        page.setTotalPages((int)Math.ceil(page.getTotalCount() * 1.0 / maxCount));
        return page;
    }
}
