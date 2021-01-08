package com.mystroe.controller;

import com.mystroe.pojo.Product;
import com.mystroe.service.ProductService;
import com.mystroe.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getProductList();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/product_list.jsp").forward(req,resp);
    }
}
