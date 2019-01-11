package com.isoft.dao;

import com.isoft.dbutil.DBUtiles;
import com.isoft.pojo.User;

import java.util.List;

public class UserDAO {

    public List<User> findAllUser(){
        DBUtiles dbUtils = new DBUtiles();
        return dbUtils.findAllUser();
    }
    public int login(User user){
        DBUtiles dbUtils = new DBUtiles();
        int temp =  dbUtils.login(user);
        return temp;
    }
}
