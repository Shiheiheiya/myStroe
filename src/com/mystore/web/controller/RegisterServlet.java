package com.mystore.web.controller;

import com.mystore.web.pojo.User;
import com.mystore.web.service.UserService;
import com.mystore.web.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService userService = new UserServiceImpl();
            //处理中文乱码
            req.setCharacterEncoding("utf-8");
            //接受前端数据
            Map<String, String[]> parameterMap = req.getParameterMap();
            User user = new User();
            //采用BeanUtil映射存入user，注意要求两者中待接收的参数名要一致
            BeanUtils.populate(user , parameterMap);
            int rows = userService.registerUser(user, req.getParameterValues("hobby"));
            if(rows > 0){
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }else {
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
