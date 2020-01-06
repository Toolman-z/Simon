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
import com.alibaba.fastjson.JSONArray;
import com.zyx.Model.Meeting;
import com.zyx.Model.Reservemeeting;
import com.zyx.Service.MeetingService;
@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = -3946332699228683929L;
    private MeetingService meetingService=new MeetingService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int totalCount=0;//������
		int totalpage=0;//��ҳ��
		int page=Integer.parseInt(req.getParameter("page"));//��ǰҳ
		int row=10;//ÿҳ��ʾ����
		String meetingname=req.getParameter("meetingname");//ȡ�û�������		
		String roomname=req.getParameter("roomname");//ȡ�û���������
		String reservername=req.getParameter("reservername");//ȡ��Ԥ��������
		String reservefromdate=req.getParameter("reservefromdate");//ȡ��Ԥ������ʱ��ο�ʼʱ��
		String reservetodate=req.getParameter("reservetodate");//ȡ��Ԥ��ʱ��ν���ʱ��
		String meetingfromdate=req.getParameter("meetingfromdate");//ȡ�û��鿪ʼʱ��
		String meetingtodate=req.getParameter("meetingtodate");//ȡ�û������ʱ�� 
		Reservemeeting reservemeeting=new Reservemeeting();
		reservemeeting.setMeetingname(meetingname);
		reservemeeting.setRoomname(roomname);
		reservemeeting.setReservername(reservername);
		reservemeeting.setReservefromdate(reservefromdate);
		reservemeeting.setReservetodate(reservetodate);
		reservemeeting.setMeetingfromdate(meetingfromdate);
		reservemeeting.setMeetingtodate(meetingtodate);
		reservemeeting.setPage(page);
		String roomid=meetingService.selectroomid(roomname);//ͨ������Ļ������������õ�������id
		reservemeeting.setRoomid(roomid);
		String employeeid=meetingService.selectemployeeid(reservername);//ͬ�������Ԥ�����������ж�Ԥ����id
		reservemeeting.setEmployeeid(employeeid);
		List<Reservemeeting> querylist=this.meetingService.query(reservemeeting);
		totalCount = this.meetingService.countquery(reservemeeting);//��ѯ������
		totalpage = totalCount % row ==0 ? totalCount / row :totalCount / row+1;//�ֳɼ�ҳ
		reservemeeting=new Reservemeeting();
		reservemeeting.setPage(page);
		reservemeeting.setTotalCount(totalCount);
		reservemeeting.setTotalpage(totalpage);
		querylist.add(reservemeeting);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(querylist);
		out.write(json);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	java.util.Date date=new java.util.Date();
    String datestr=java.text.DateFormat.getDateTimeInstance().format(date);//�õ���ǰʱ��
	String re=null;
	String meetingid=null;
	String reserveuserid=req.getParameter("reserveuserid");//ȡ����ǰ��¼�˺ŵ�id
	String meetingname=req.getParameter("meetingname");//ȡ������Ļ�������
	String meetingpersonnum=req.getParameter("personnumber");//ȡ��Ԥ�Ʋλ�����
	String meetingstarttime=req.getParameter("startdate");//ȡ�����鿪ʼʱ��
	String meetingendtime=req.getParameter("enddate");//ȡ���������ʱ��
	String roomid=req.getParameter("roomid");//ȡ��������id
	String remark=req.getParameter("remark");//ȡ������˵��
	String[] employeeid=req.getParameterValues("employeeid[]");//ȡ���λ���Աid����	
	System.out.println(meetingname);
	System.out.println(employeeid);
	System.out.println(roomid);
	System.out.println(reserveuserid);//�����ܷ�ȡֵ
	Meeting meeting=new Meeting();
	meeting.setReserveuserid(reserveuserid);
	meeting.setMeetingname(meetingname);
	meeting.setMeetingpersonnum(meetingpersonnum);
	meeting.setMeetingstarttime(meetingstarttime);
	meeting.setMeetingendtime(meetingendtime);
	meeting.setRoomid(roomid);
	meeting.setMeetingremark(remark);
	meeting.setReservetime(datestr);
	re=meetingService.insert(meeting);	
	meetingid=meetingService.select(meeting);
	for(int i=0;i<employeeid.length;i++) {
			String a=employeeid[i];
		String res=meetingService.insertid(a,meetingid);
	}
	PrintWriter out = resp.getWriter(); //�����
		if(re == "true") {
			
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
		out.close();
	}

}
