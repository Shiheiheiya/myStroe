package com.mystore.web.controller;

import com.mystore.web.pojo.Product;
import com.mystore.web.service.ProductService;
import com.mystore.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        //接受前端传递的参数
        String pid = req.getParameter("pid");
        //创建服务类
        ProductService productService = new ProductServiceImpl();
        //执行服务方法获取产品信息
        Product product = productService.getProductByPid(pid);
        //装入req
        req.setAttribute("product", product);
        //转发req resp
        req.getRequestDispatcher("/product_info.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
