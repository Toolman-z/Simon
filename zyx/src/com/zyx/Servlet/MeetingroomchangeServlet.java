package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zyx.Model.Meetingroom;
import com.zyx.Service.MeetingroomService;
@WebServlet("/roomchange")
public class MeetingroomchangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1284850898084342654L;	
	private MeetingroomService  meetingroomService=new MeetingroomService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String roomid=req.getParameter("roomid");
	  List<Meetingroom> list =this.meetingroomService.changeMeetingrooms(roomid);
	  req.setAttribute("meetingroomlist", list);	
		PrintWriter out=resp.getWriter();
		out.write("true");
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String change=null;
		String roomnum=req.getParameter("roomnum");
		String roomname=req.getParameter("roomname");
		String roomid=req.getParameter("roomid");
		String capacity=req.getParameter("capacity");
		String remark=req.getParameter("remark");
		String status=req.getParameter("status");		
		Meetingroom meetingroom=new Meetingroom();
		meetingroom.setRoomnum(roomnum);
		meetingroom.setRoomname(roomname);
		meetingroom.setRoomid(Integer.parseInt(roomid));
		meetingroom.setCapacity(Integer.parseInt(capacity));
		meetingroom.setRemark(remark);
		meetingroom.setStatus(Integer.parseInt(status));
		System.out.println(roomname);
		change=meetingroomService.change(meetingroom);
		 PrintWriter out = resp.getWriter(); //Êä³öÁ÷
	  		if(change == "true") {	  			
	  			out.write("true");
	  		}else {
	  			out.write("false");
	  		}
	  		out.flush();
	  		out.close();
	}


}
