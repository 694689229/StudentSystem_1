package com.isoft.controller;

import com.isoft.pojo.User;
import com.isoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")//先把User中的u改成小写
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String role = request.getParameter("role");
        //从服务来获取值
        UserService userService = new UserService();
        User user = new User();
        user.setUpwd(upwd);
        user.setUname(uname);
        user.setRole(role);
        if (userService.login(user)) {
            List<User> alllUser = userService.findAllUser();
            //session会话
            HttpSession session = request.getSession();
            session.setAttribute("userList", alllUser);
            response.sendRedirect("showUserInfo.jsp");
        } else {
            response.sendRedirect("login.html");
        }
        //硬编码
//        if (uname.equals("admin")&&upwd.equals("123456")){
//            response.sendRedirect("showUserInfo.jsp");
//        }else{
//            response.sendRedirect("login.html");
//        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String role = request.getParameter("role");
        System.out.println(uname+"-"+upwd+"-"+role);
        UserService userService = new UserService();
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        user.setRole(role);
        boolean login = userService.login1(user);
        PrintWriter out = response.getWriter();
        if (login) {
            out.print(1);
        } else {
            out.print(0);

        }
        out.close();
        System.out.println("sss");
    }
}
