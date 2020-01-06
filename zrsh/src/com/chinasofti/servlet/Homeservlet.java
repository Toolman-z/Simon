package com.chinasofti.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Homeservlet extends HttpServlet {	
	private static final long serialVersionUID = 7328954889510177778L;
	
	public  Homeservlet() {
		System.out.println("1.初始化Servlet");
	}	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.调用有参init方法");
		
		super.init(config);
	}	
	@Override
	public void init() throws ServletException {		
		System.out.println("3.调用无参init方法");
		
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4.调用Service方法,判断请求是get ，还是post");
		super.service(req, resp);
	}	
	@Override
	public void destroy() {
		System.out.println("5.销毁Servlet方法");
		super.destroy();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {						
		HttpSession session = req.getSession();
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		Object obj =session.getAttribute("login");
		if(obj!= null) {
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			return;
		}
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User login=new User();
		login.setName(username);
		login.setPassword(password);
		Dao dao=new Dao();				
		System.out.println("1"+dao.select(login)+"1");
		if(dao.select(login)) {
			//resp.sendRedirect("user.jsp");
			
			
			session.setAttribute("login", "true");
		req.getRequestDispatcher("user.jsp").forward(req,resp);
		System.out.println("成功了");
		}else {        	
    		System.out.println("失败了");
    		req.getRequestDispatcher("login.jsp").forward(req,resp);
        }        
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String z_username=req.getParameter("z_username");
		String z_password=req.getParameter("z_password");
		User zhuce=new User();
		zhuce.setName_z(z_username);
		zhuce.setPassword_z(z_password);
		Dao dao=new Dao();
		System.out.println("1"+dao.insert(zhuce)+"1");
		if(dao.insert(zhuce)) {
			PrintWriter out=resp.getWriter();
			out.write("<!DOCTYPE html>") ;
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"utf-8\" />");
			out.write("<title></title>");
			out.write("<head>");
			out.write("<body>");
			out.write("<h1>注册成功了</h1>");
			out.write("<h1>邹运可以变成精神小伙了</h1>");
			System.out.println("成功了");
			out.write("<h7>您的账号是："+z_username+"<h7>");
			out.write("<h7>您的密码是："+z_password+"<h7>");
			out.write("<h7>您的IP是："+req.getRemoteAddr()+"</h7>");
			out.write("<body>");
			out.write("</head>");
			out.write("</html>");
	        out.flush();
	        out.close();
			
		}else {
			PrintWriter out=resp.getWriter();
			out.write("<!DOCTYPE html>") ;
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"utf-8\" />");
			out.write("<title></title>");
			out.write("<head>");
			out.write("<body>");
			out.write("<h1>注册失败了</h1>");
			out.write("<h1>时总正在赶来的路上</h1>");
			System.out.println("失败了");
			out.write("<h7>您的账号是："+z_username+"<h7>");
			out.write("<h7>您的密码是："+z_password+"<h7>");
			out.write("<h7>您的IP是："+req.getRemoteAddr()+"</h7>");
			out.write("<body>");
			out.write("</head>");
			out.write("</html>");
	        out.flush();
	        out.close();
		}
	}

}
