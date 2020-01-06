package com.chinasofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8945659626145054989L;
	
	private UserService userService  = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.获取登录讯息 2、查询数据库 3、根据结果跳转
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//MVC模式 servlet 调用 service，service调用dao
		User user = this.userService.login(username, password);
		if(user == null) {
			req.setAttribute("massage", "密码或账号错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {			
			req.getRequestDispatcher("user.jsp").forward(req, resp);
		}
	}

}
