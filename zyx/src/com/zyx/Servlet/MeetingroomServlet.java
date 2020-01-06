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
@WebServlet("/imge")
public class MeetingroomServlet extends HttpServlet {
	private MeetingroomService  meetingroomService=new MeetingroomService();
	private static final long serialVersionUID = -3720866701621167109L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {			
      List<Meetingroom> list =this.meetingroomService.queryMeetingrooms();
      req.setAttribute("meetingroomlist", list);
		req.getRequestDispatcher("meetingrooms.jsp").forward(req,resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		  	
		String a=null;
		String roomnumber=req.getParameter("housenumber");
		System.out.println(roomnumber);//测试
  		String capacity=req.getParameter("meetingname");
  		String roomcapacity=req.getParameter("maxpeople");
  		String remarks=req.getParameter("remarks");
  		String status=req.getParameter("status");
  		//向前台取值
  		Meetingroom meetingroom=new Meetingroom();
  		meetingroom.setRoomname(capacity);//向modal层写入会议室名称
  		meetingroom.setRoomnum(roomnumber); //向modal层写入门牌号		
  		meetingroom.setCapacity(Integer.parseInt(roomcapacity));//向modal层中写入最大容纳人数
  		meetingroom.setRemark(remarks);//向modal层中写入备注
  		meetingroom.setStatus(Integer.parseInt(status));
  		System.out.println(roomcapacity);//测试控制台是否输出
  		a=meetingroomService.insert(meetingroom);
  		PrintWriter out = resp.getWriter();
  		if(a == "true") {
  			out.write("true");
  		}else {
  			out.write("false");
  		}
  		out.flush();
  		out.close();
	}

}
