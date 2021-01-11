package com.mystore.admin.service.impl;

import com.mystore.admin.dao.CategoryDao;
import com.mystore.admin.pojo.Category;
import com.mystore.admin.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao;

    public CategoryServiceImpl(){
        categoryDao = new CategoryDao();
    }
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
