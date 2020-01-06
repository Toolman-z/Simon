package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zyx.Service.MeetingService;
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = -4957777614545790797L;
    private MeetingService meetingService= new MeetingService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String rs="";
	String change=req.getParameter("change");
	String id=req.getParameter("reserveuserid");
	String meetingid=req.getParameter("meetingid");
	rs=meetingService.insertchange(id,meetingid,change);
	PrintWriter out = resp.getWriter(); //输出流
	 if(rs =="true") {
		 out.write("true");
	 }else {
		 out.write("false");
	 }
	 out.flush();
	 out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String rs="";
		String meetingid=req.getParameter("meetingid");
		String id=req.getParameter("reserveuserid");
		rs=meetingService.test(id,meetingid);
		 PrintWriter out = resp.getWriter(); //输出流
		 if(rs =="true") {
			 out.write("true");
		 }else {
			 out.write("false");
		 }
		 out.flush();
		 out.close();
	}		
	}


