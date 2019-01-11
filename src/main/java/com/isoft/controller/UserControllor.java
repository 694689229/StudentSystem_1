package com.isoft.controller;

import com.isoft.pojo.User;
import com.isoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserControllor {
    @Autowired
    UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(User user){
        System.out.println("hhhhh");
        UserService userService=new UserService();
        boolean login = userService.login1(user);
        return String.valueOf(login);
    }
    public List findAllUser(){

        return null;
    }
}
