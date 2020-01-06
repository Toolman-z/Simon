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
		int totalCount=0;//总条数
		int totalpage=0;//总页数
		int page=Integer.parseInt(req.getParameter("page"));//当前页
		int row=10;//每页显示条数
		String meetingname=req.getParameter("meetingname");//取得会议名称		
		String roomname=req.getParameter("roomname");//取得会议室名称
		String reservername=req.getParameter("reservername");//取得预定者姓名
		String reservefromdate=req.getParameter("reservefromdate");//取得预定会议时间段开始时间
		String reservetodate=req.getParameter("reservetodate");//取得预定时间段结束时间
		String meetingfromdate=req.getParameter("meetingfromdate");//取得会议开始时间
		String meetingtodate=req.getParameter("meetingtodate");//取得会议结束时间 
		Reservemeeting reservemeeting=new Reservemeeting();
		reservemeeting.setMeetingname(meetingname);
		reservemeeting.setRoomname(roomname);
		reservemeeting.setReservername(reservername);
		reservemeeting.setReservefromdate(reservefromdate);
		reservemeeting.setReservetodate(reservetodate);
		reservemeeting.setMeetingfromdate(meetingfromdate);
		reservemeeting.setMeetingtodate(meetingtodate);
		reservemeeting.setPage(page);
		String roomid=meetingService.selectroomid(roomname);//通过输入的会议室名称来得到会议室id
		reservemeeting.setRoomid(roomid);
		String employeeid=meetingService.selectemployeeid(reservername);//同过输入的预定者姓名来判断预定着id
		reservemeeting.setEmployeeid(employeeid);
		List<Reservemeeting> querylist=this.meetingService.query(reservemeeting);
		totalCount = this.meetingService.countquery(reservemeeting);//查询总条数
		totalpage = totalCount % row ==0 ? totalCount / row :totalCount / row+1;//分成几页
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
    String datestr=java.text.DateFormat.getDateTimeInstance().format(date);//得到当前时间
	String re=null;
	String meetingid=null;
	String reserveuserid=req.getParameter("reserveuserid");//取到当前登录账号的id
	String meetingname=req.getParameter("meetingname");//取到输入的会议名称
	String meetingpersonnum=req.getParameter("personnumber");//取到预计参会人数
	String meetingstarttime=req.getParameter("startdate");//取到会议开始时间
	String meetingendtime=req.getParameter("enddate");//取到会议结束时间
	String roomid=req.getParameter("roomid");//取到会议室id
	String remark=req.getParameter("remark");//取到会议说明
	String[] employeeid=req.getParameterValues("employeeid[]");//取到参会人员id名单	
	System.out.println(meetingname);
	System.out.println(employeeid);
	System.out.println(roomid);
	System.out.println(reserveuserid);//测试能否取值
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
	PrintWriter out = resp.getWriter(); //输出流
		if(re == "true") {
			
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
		out.close();
	}

}
