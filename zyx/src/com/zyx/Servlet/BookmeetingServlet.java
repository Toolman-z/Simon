package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zyx.Model.Department;
import com.zyx.Model.Meetingroom;
import com.zyx.Service.DepartmentService;
import com.zyx.Service.MeetingroomService;
@WebServlet("/bookmeeting")
public class BookmeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 3147767470285214215L;
	 private DepartmentService departmentService = new DepartmentService();
	private MeetingroomService meetingroomService=new MeetingroomService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<Department> list = this.departmentService.queryDepartment();
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(list);
		out.write(json);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		System.out.println(startdate);
		System.out.println(enddate);
		List<Meetingroom> list =this.meetingroomService.query(startdate,enddate);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(list);
		out.write(json);
		out.flush();
		out.close();
	}

}
