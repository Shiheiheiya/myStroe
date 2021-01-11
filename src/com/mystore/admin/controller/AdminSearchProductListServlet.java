package com.mystore.admin.controller;

import com.mystore.admin.pojo.Product;
import com.mystore.admin.service.CategoryService;
import com.mystore.admin.service.ProductService;
import com.mystore.admin.service.impl.CategoryServiceImpl;
import com.mystore.admin.service.impl.ProductServiceImpl;
import com.mystore.admin.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicTreeUI;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 查询，模糊匹配
 */
@WebServlet("/adminSearchProductList")
public class AdminSearchProductListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Condition condition = new Condition();
            ProductService productService = new ProductServiceImpl();
            CategoryService categoryService = new CategoryServiceImpl();
            BeanUtils.populate(condition , req.getParameterMap());
            List<Product> productList = productService.getProductListByCondition(condition);
            req.setAttribute("condition",condition);
            req.setAttribute("productList",productList);
            req.setAttribute("categoryList",categoryService.getCategoryList());
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
