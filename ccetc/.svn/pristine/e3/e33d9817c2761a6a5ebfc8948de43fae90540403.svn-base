package com.chinasofti.util;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.user.User;

public class SessionUtil {
	
	public static String userId(HttpSession session) {
		Object obj = session.getAttribute("user");
		if(obj == null)return "";
		User user = (User)obj;
		return user.getUserid();
	}

}
