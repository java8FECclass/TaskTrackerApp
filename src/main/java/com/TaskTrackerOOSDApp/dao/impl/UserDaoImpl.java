package com.TaskTrackerOOSDApp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.TaskTrackerOOSDApp.dao.UserDao;
import com.TaskTrackerOOSDApp.model.User;

//This Class must implement UserDAO Interface and implement all 
//abstract methods for 
//example: retrieveUserByUserName(String Username);-> returns User Object
//by using spring JDBC to connect to DB and retrieve data from User table
@Repository
public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public User retrieveByUserName(String username) {
	      String sql = "select * from user where username=?";
	        User user = (User) jdbcTemplate.queryForObject(sql, new Object[]
	        { username }, new RowMapper<User>()
	        {
	            @Override
	            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	            {
	                User user = new User();
	                user.setName(rs.getString(1));
	                user.setPassword(rs.getString(2));
	                return user;
	            }
	        });
	        return user;
	}

}
