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
import com.zyx.Model.Meetingroom;
import com.zyx.Model.Register;
import com.zyx.Service.MeetingroomService;
import com.zyx.Service.RegisterService;
@WebServlet("/try")
public class TryServlet extends HttpServlet {
	private static final long serialVersionUID = -6632237340285526213L;
	private MeetingroomService meetingroomService=new MeetingroomService();
	private RegisterService registerService =new RegisterService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String roomid=req.getParameter("roomid"); 
		
		List<Meetingroom> list =this.meetingroomService.changeMeetingrooms(roomid);
		  req.setAttribute("meetingroomlist", list);
		  System.out.println(JSON.toJSONString(list));
			req.getRequestDispatcher("roomdetails.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String departmentid=req.getParameter("departmentid");
		System.out.println(departmentid);
		List<Register> list =this.registerService.query(departmentid);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(list);
		out.write(json);
		out.flush();
		out.close();
	}

}
