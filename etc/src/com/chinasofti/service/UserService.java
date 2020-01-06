package com.chinasofti.service;
import java.util.List;
import com.chinasofti.Dao.UserDao;
import com.chinasofti.model.User;

public class UserService {
	
	private UserDao userDao = new UserDao();

	public User login(String username, String password) {
		return userDao.select(username,password);
	}

	public List<User> queryUsers() {
		return userDao.queryUsers();
	}

	public boolean reg(String username, String password) {
		return userDao.reg(username,password);
	}
	public List<User> queryPassword(String username) {
		return userDao.queryPassword(username);
	}
	public List<User> queryUsername(String password) {
		return userDao.queryPassword(password);
	}
}
