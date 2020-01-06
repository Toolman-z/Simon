package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyx.Model.Department;
import com.zyx.Service.DepartmentService;
@WebServlet("/change")
public class DepartmentchangeServlet extends HttpServlet {	
	private static final long serialVersionUID = 4385442546596376396L;
	private DepartmentService departmentService = new DepartmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delt;
		String id = req.getParameter("id");
		Department department =new Department();
		department.setDepartmentid(Integer.parseInt(id));
		delt=departmentService.delet(department);
		 PrintWriter out = resp.getWriter(); //输出流
	  		if(delt == "true") {
	  			System.out.println(delt);
	  			out.write("true");
	  		}else {
	  			out.write("false");
	  		}
	  		out.flush();
	  		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String change;
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		Department department=new Department();
		department.setDepartmentid(Integer.parseInt(id));
		department.setDepartmentname(name);
		change=departmentService.change(department);
		 PrintWriter out = resp.getWriter(); //输出流
	  		if(change == "true") {
	  			System.out.println(change);
	  			out.write("true");
	  		}else {
	  			out.write("false");
	  		}
	  		out.flush();
	  		out.close();
	}

}
