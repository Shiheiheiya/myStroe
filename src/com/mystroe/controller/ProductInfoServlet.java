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

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getProduct(req.getParameter("id"));
        System.out.println(productList.get(0));
        req.setAttribute("product", productList.get(0));
        req.getRequestDispatcher("/product_info.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
