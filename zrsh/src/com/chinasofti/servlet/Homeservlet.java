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
		System.out.println("�ɹ���");
		}else {        	
    		System.out.println("ʧ����");
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
			out.write("<h1>ע��ɹ���</h1>");
			out.write("<h1>���˿��Ա�ɾ���С����</h1>");
			System.out.println("�ɹ���");
			out.write("<h7>�����˺��ǣ�"+z_username+"<h7>");
			out.write("<h7>���������ǣ�"+z_password+"<h7>");
			out.write("<h7>����IP�ǣ�"+req.getRemoteAddr()+"</h7>");
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
			out.write("<h1>ע��ʧ����</h1>");
			out.write("<h1>ʱ�����ڸ�����·��</h1>");
			System.out.println("ʧ����");
			out.write("<h7>�����˺��ǣ�"+z_username+"<h7>");
			out.write("<h7>���������ǣ�"+z_password+"<h7>");
			out.write("<h7>����IP�ǣ�"+req.getRemoteAddr()+"</h7>");
			out.write("<body>");
			out.write("</head>");
			out.write("</html>");
	        out.flush();
	        out.close();
		}
	}

}
