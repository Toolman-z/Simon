package com.chinasofti.service;
import com.chinasofti.dao.UserDao;
import com.chinasofti.model.User;


public class UserService {
	private UserDao userDao=new UserDao();

	public String insert(User user) {
		String rs=null;
		boolean boo = userDao.insert(user);
		if(boo) {		
			rs="{'cmd':'1','code':'0','uid':'"+user.getUid()+"'}";
		}else {
			rs="{'cmd':'1','code':'1'}";
		}
		return rs;
		
	}
	public String select(User login) {
		String rs=null;
		boolean boo =userDao.select(login);
		if(boo) {
			rs="{'cmd':'0','code':'0','login':'0','uid':'"+login.getUid()+"'}";
		}else {
			rs="{'cmd':'0','code':'1','login':'1'}";
		}
		return rs;
	}

}
