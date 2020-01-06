package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.zyx.Model.Department;
import com.zyx.Service.DepartmentService;
@WebServlet("/add")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = -7702776318331404054L;
    private DepartmentService departmentService = new DepartmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Department> list = this.departmentService.queryDepartment();
	req.setAttribute("departmentlist", list);
	req.getRequestDispatcher("departments.jsp").forward(req,resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String test =null;
		String name= req.getParameter("departmentname");
		    Department department=new Department();
		    department.setDepartmentname(name);//封装进Model层
		 test=departmentService.insert(department);  //把insert方法的返回值赋给test
		 PrintWriter out = resp.getWriter(); //输出流
	  		if(test == "true") {
	  			out.write("true");
	  		}else {
	  			out.write("false");
	  		}
	  		out.flush();
	  		out.close();
	}	

	

}
