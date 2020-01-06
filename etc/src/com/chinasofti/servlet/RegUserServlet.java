package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.service.UserService;

public class RegUserServlet extends HttpServlet {

	private static final long serialVersionUID = -8945659626145054989L;
	
	private UserService userService  = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean boo = this.userService.reg(username, password);
		if(boo) {
			resp.sendRedirect("login.jsp");
		}else {
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}
	}

}
