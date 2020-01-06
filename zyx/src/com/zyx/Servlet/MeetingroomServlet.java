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
		System.out.println(roomnumber);//����
  		String capacity=req.getParameter("meetingname");
  		String roomcapacity=req.getParameter("maxpeople");
  		String remarks=req.getParameter("remarks");
  		String status=req.getParameter("status");
  		//��ǰ̨ȡֵ
  		Meetingroom meetingroom=new Meetingroom();
  		meetingroom.setRoomname(capacity);//��modal��д�����������
  		meetingroom.setRoomnum(roomnumber); //��modal��д�����ƺ�		
  		meetingroom.setCapacity(Integer.parseInt(roomcapacity));//��modal����д�������������
  		meetingroom.setRemark(remarks);//��modal����д�뱸ע
  		meetingroom.setStatus(Integer.parseInt(status));
  		System.out.println(roomcapacity);//���Կ���̨�Ƿ����
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
