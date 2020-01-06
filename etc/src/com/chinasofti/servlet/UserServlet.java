package com.chinasofti.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -8945659626145054989L;
	
	private UserService userService  = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//只需要在service里查询出所有数据 用请求属性送到user.jsp
		req.setAttribute("nowDate", new Date());
		if (req.getParameter("username").equals("")&&req.getParameter("password").equals("")) {
			List<User> list = this.userService.queryUsers();
			req.setAttribute("userList", list);
			req.getRequestDispatcher("user.jsp").forward(req, resp);
		} else if(!req.getParameter("username").equals("")&&req.getParameter("password").equals("")) {
			List<User> list = this.userService.queryPassword(req.getParameter("username"));
			req.setAttribute("userList", list);
			req.getRequestDispatcher("user.jsp").forward(req, resp);
		} else if (req.getParameter("username").equals("")&&!req.getParameter("password").equals("")) {
			List<User> list = this.userService.queryPassword(req.getParameter("password"));
			req.setAttribute("userList", list);
			req.getRequestDispatcher("user.jsp").forward(req, resp);
		}
		
		
	}

}
