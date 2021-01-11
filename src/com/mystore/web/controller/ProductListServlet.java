package com.mystore.web.controller;

import com.mystore.web.pojo.Product;
import com.mystore.web.service.ProductService;
import com.mystore.web.service.impl.ProductServiceImpl;
import com.mystore.web.vo.Page;

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
        req.setCharacterEncoding("utf-8");
        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        int maxCount = 12;//通常由前端传过来
        //封装page对象，返回给前端
        ProductService productService = new ProductServiceImpl();
//        List<Product> productList = productService.getProductList();
//        req.setAttribute("productList", productList);
        Page page = productService.getPageByCurrentPageAndMaxCount(currentPage , maxCount);
        req.setAttribute("page" , page);
        req.getRequestDispatcher("/product_list.jsp").forward(req,resp);
    }
}
