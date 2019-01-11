package com.isoft.dbutil;

import com.isoft.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtiles {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    public DBUtiles(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb?serverTimezone=GMT%2B8","root","root");
            if(conn!=null){
                System.out.println("成功");
            }else{
                System.out.println("为空");
            }
        }catch (Exception e){
            System.out.println("失败"+e.getMessage());
        }
    }
    public int login(User user){
        try {
            pstmt = conn.prepareStatement("select * from tb_stu where uname=? and upwd=?");
            pstmt.setString(1,user.getUname());
            pstmt.setString(2,user.getUpwd());
            pstmt.setString(3,user.getRole());
            rs = pstmt.executeQuery();
            if(rs.next())
                return 1;
            else
                return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public List<User> findAllUser() {
        try {
            String sql = "select * from tb_stu";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setRole(rs.getString(4));

                list.add(user);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

