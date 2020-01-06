package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyx.Model.Employee;
import com.zyx.Model.Meeting;
import com.zyx.Model.Reservemeeting;
import com.zyx.Service.RegisterService;
@WebServlet("/rep")
public class RepeatServlet extends HttpServlet {
	private static final long serialVersionUID = 2473350471254480401L;
private RegisterService registerservice=new RegisterService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String meetingid=req.getParameter("meetingid");
	String roomid=req.getParameter("roomid");
	System.out.println(meetingid);
	System.out.println(roomid);
	List<Reservemeeting> list =this.registerservice.selectMeetingroom(roomid,meetingid);	
	List<Employee> employeelist=this.registerservice.selectEmployee(meetingid);	
	//for(int i=0;i<employeelist.size();i++) {
	//	list.add(employeelist.get(i));
	//}
	Meeting meeting=new Meeting();
	meeting.setMeetingid(meetingid);
	HttpSession session=req.getSession();
	session.setAttribute("meetingid", meeting);
	req.setAttribute("employeelist", employeelist);
	req.setAttribute("reservemeetinglist", list);
	req.getRequestDispatcher("meetingdetails.jsp").forward(req,resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
	    String username=req.getParameter("username");
        String user =registerservice.repeat(username);
		System.out.println(username);
		PrintWriter out = resp.getWriter(); //Êä³öÁ÷
		if(user != null) {			
			out.write("false");
		}else {
			out.write("true");
		}
		out.flush();
	    out.close();
	}

}
