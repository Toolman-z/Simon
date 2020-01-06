package com.zyx.Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zyx.Service.DepartmentService;
import com.zyx.Service.RegisterService;
import java.util.List;
import com.zyx.Model.Department;
import com.zyx.Model.Register;
@WebServlet("/find")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = -5357731251173317635L;
	private DepartmentService departmentService = new DepartmentService();
	private RegisterService registerService =new RegisterService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Department> list = this.departmentService.queryDepartment();
		req.setAttribute("departmentlist", list);
		req.getRequestDispatcher("register.jsp").forward(req,resp);			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Register> list =this.registerService.queryRegister();
	req.setAttribute("registerlist", list);
	req.getRequestDispatcher("approveaccount.jsp").forward(req,resp);	
	}

}
