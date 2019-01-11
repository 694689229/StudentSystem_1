package com.isoft.service;


import com.isoft.dao.UserDAO;
import com.isoft.dao.UserDAO_1;
import com.isoft.pojo.User;

import java.util.List;

public class UserService {
    UserDAO dao = new UserDAO();
    UserDAO_1 dao1 = new UserDAO_1();

    public List<User> searchUserByRole(String role) {
        return dao1.searchUserByRole(role);
    }

    public boolean addUserInfo(User user) {
        int i = dao1.addUserInfo(user);
        if (i > 0)
            return true;
        else
            return false;
    }

    public boolean deleteUserById(String id) {
        int i = dao1.deleteUserById(id);
        if (i > 0)
            return true;
        else
            return false;
    }

    public List<User> findAllUser() {
        return dao.findAllUser();
    }

    public boolean login(User user) {
        int temp = dao.login(user);
        if (temp == 0) return false;
        else return true;
    }

    public boolean login1(User user) {
        int temp = dao1.login(user);
        if (temp == 0) return false;
        else return true;
    }
}