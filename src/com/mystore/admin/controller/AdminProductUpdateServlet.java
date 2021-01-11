package com.mystore.admin.controller;

import com.mystore.admin.pojo.Product;
import com.mystore.admin.service.ProductService;
import com.mystore.admin.service.impl.ProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/adminProductUpdate")
public class AdminProductUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ProductService productService = new ProductServiceImpl();
            req.setCharacterEncoding("utf-8");
            Product product = new Product();
            BeanUtils.populate(product , req.getParameterMap());
            int rows = productService.updateProduct(product);
            if(rows > 0){
                resp.sendRedirect(req.getContextPath() + "/adminProductList");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
