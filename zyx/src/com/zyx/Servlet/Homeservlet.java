package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zyx.Dao.Dao;
import com.zyx.Model.Employee;
import com.zyx.Service.RegisterService;
@WebServlet("/home")
public class Homeservlet extends HttpServlet {
	private static final long serialVersionUID = -1930781389053759208L;
	private RegisterService registerService=new RegisterService();
	public  Homeservlet() {
		System.out.println("1.��ʼ��Servlet");
	}	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.�����в�init����");
		
		super.init(config);
	}	
	@Override
	public void init() throws ServletException {		
		System.out.println("3.�����޲�init����");
		
		super.init();
	}	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4.����Service����,�ж�������get ������post");
		super.service(req, resp);
	}	
	@Override
	public void destroy() {
		System.out.println("5.����Servlet����");
		super.destroy();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {										
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		String password=req.getParameter("password");						
		Employee user=registerService.login(username,password);				
		 PrintWriter out = resp.getWriter(); //�����
	  		if(user !=null) {
	  			out.write("true");
	  			session.setAttribute("login", "true");
	  			session.setAttribute("user", user);
	  		}else {
	  			out.write("fail");
	  		}
	  		out.flush();
	  		out.close();    
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		boolean zhu;
		String z_username=req.getParameter("accountname");
		String z_password=req.getParameter("password");
		String z_realname=req.getParameter("employeename");
		String z_phone=req.getParameter("phone");
		String z_email=req.getParameter("email");
		String z_departmentid=req.getParameter("departmentid");
		Employee zhuce=new Employee();
		zhuce.setUsername(z_username);
		zhuce.setPassword(z_password);
		zhuce.setEmail(z_email);
		zhuce.setPhone(z_phone);
		zhuce.setRealname(z_realname);
		zhuce.setDepartmentid(Integer.parseInt(z_departmentid));
		Dao dao=new Dao();	
		zhu=dao.insert(zhuce);
		PrintWriter out = resp.getWriter(); //�����
  		if(zhu == true) {
  			out.write("true");
  		}else {
  			out.write("false");
  		}
  		out.flush();
  		out.close();
	}
}
