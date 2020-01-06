package com.chinasofti.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.db.DbUtil;
import com.chinasofti.model.User;

public class UserDao {

	public User select(String username, String password) {
		User user = null;
		DbUtil db = new DbUtil();
		Statement stm = db.getStatement();
		String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return user;
	}

	public List<User> queryUsers() {
		List<User> list = new ArrayList<User>();
		DbUtil db = new DbUtil();
		Statement stm = db.getStatement();
		String sql = "select * from user";
		try {
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return list;
	}

	public boolean reg(String username, String password) {
		boolean boo = true;
		DbUtil db = new DbUtil();
		Statement stm = db.getStatement();
		String sql = "insert into user values ('" + username + "','" + password + "')";
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			boo = false;
			e.printStackTrace();
		}
		db.closeConnection();
		return boo;
	}
	
	public List<User> queryPassword(String username) {
		List<User> list = new ArrayList<User>();
		DbUtil db = new DbUtil();
		Statement stm = db.getStatement();
		String sql = "select * from user where username ="+username+"";
		try {
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return list;
	}
	
	public List<User> queryUsername(String password) {
		List<User> list = new ArrayList<User>();
		DbUtil db = new DbUtil();
		Statement stm = db.getStatement();
		String sql = "select * from user where password ="+password+"";
		try {
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return list;
	}
}
