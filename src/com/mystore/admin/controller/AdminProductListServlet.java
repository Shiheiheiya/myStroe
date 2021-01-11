package com.mystore.admin.controller;

import com.mystore.admin.pojo.Product;
import com.mystore.admin.service.CategoryService;
import com.mystore.admin.service.impl.CategoryServiceImpl;
import com.mystore.admin.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminProductList")
public class AdminProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> productList = productService.getProductList();
        CategoryService categoryService = new CategoryServiceImpl();
        req.setAttribute("productList" , productList);
        System.out.println(productList.size());
        req.setAttribute("categoryList" , categoryService.getCategoryList());
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req ,resp);
    }
}
