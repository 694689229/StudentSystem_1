package com.isoft.dao;

import com.isoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDAO_2 {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<User> searchUserByRole(String role){
        String sql="select * from tb_login where role like ?";
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),new String[]{"%"+role+"%"});
        return list;
    }
    public int addUserInfo(User user){

        String sql="insert into tb_login(uname,upwd,role) values (?,md5(?),?)";
        int rowNum = jdbcTemplate.update(sql,user.getUname(),"000000",user.getRole());
        return rowNum;
    }
    public int deleteUserById(String id){
        String sql = "delete from tb_login where id=?";
        int update = jdbcTemplate.update(sql, new String[]{id});
        return update;
    }
    public List<User> findAllUser(){

        String sql="select * from tb_login" ;
        List<User> userList=jdbcTemplate.queryForList(sql,User.class);
        return userList;
    }
    public int login(User user){

        String sql="select * from tb_login where uname=? and upwd = ?" ;
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,new String[]{user.getUname(),user.getUpwd()});
        return maps.size();
    }
}
