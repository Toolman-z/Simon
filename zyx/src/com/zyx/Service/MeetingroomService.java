package com.zyx.Service;
import java.util.List;

import com.zyx.Dao.MeetingroomDao;
import com.zyx.Model.Meetingroom;
public class MeetingroomService {
private MeetingroomDao meetingroomDao=new MeetingroomDao();
public String insert(Meetingroom meetingroom) {
	String rs=null;
	boolean boo = meetingroomDao.insert(meetingroom);
	if(boo) {		
		rs="true";
	}else {
		rs="false";
	}
	return rs;
}
public List<Meetingroom> queryMeetingrooms() {
	// TODO Auto-generated method stub
	return meetingroomDao.queryMeetingrooms();
}
public List<Meetingroom> changeMeetingrooms(String roomid) {
	return meetingroomDao.changeMeetingrooms(roomid);
}
public String change(Meetingroom meetingroom) {
	String rs=null;
	boolean boo = meetingroomDao.change(meetingroom);
	System.out.println(boo);
	if(boo) {		
		rs="true";
	}else {
		rs="false";
	}
	return rs;
}
public List<Meetingroom> query(String startdate, String enddate) {
	// TODO Auto-generated method stub
	return meetingroomDao.query(startdate,enddate);
}
}