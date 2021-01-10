package com.mystore.web.controller;

import com.mystore.web.pojo.User;
import com.mystore.web.service.UserService;
import com.mystore.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建处理实例类service
        UserService userService = new UserServiceImpl();
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        //获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username , password);
        if(null != user){
            System.out.println("登录成功！");
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            //设置cookie时间，单位为秒 下面是60min  这个设置完还要设置session时间才真正有效
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else {
            System.out.println("登录失败！");
            req.setAttribute("loginInfo" , "用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
