package com.example.springbootjpa.service.Impl;

import com.example.springbootjpa.pojo.User;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //SpringBoot提供的数据库操作类
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("insert into users(name,age)values(?,?)", user.getName(), user.getAge());
    }

    @Override
    public User getUser(Long id) {
        final User user = new User();
        jdbcTemplate.query("select * from users where id=" + id, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(id);
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
            }
        });
        return user;
    }

    @Override
    public void updateUser(Long id, User user) {
        jdbcTemplate.update("update users set name=?,age=? where id=?", user.getName(), user.getAge(), id);

    }

    @Override
    public void deleteUser(Long id) {
        jdbcTemplate.update("delete from users where id=?", id);
    }
}

