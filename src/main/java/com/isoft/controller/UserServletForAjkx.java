package com.isoft.controller;

import com.alibaba.fastjson.JSON;
import com.isoft.pojo.User;
import com.isoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "UserServletForAjkx",urlPatterns = "/userServletForAjkx")
public class UserServletForAjkx extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String uname = request.getParameter("uname");
        String role = request.getParameter("role");
        UserService userService = new UserService();
        User user = new User();
        user.setUname(uname);
        user.setRole(role);
        boolean b = userService.addUserInfo(user);
        PrintWriter out = response.getWriter();
        out.print(b);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> allUser = userService.findAllUser();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonStr = JSON.toJSONString(allUser);
        out.print(jsonStr);//要把这个对象转换成json
        out.close();
        System.out.println("doGet");
    }
}
