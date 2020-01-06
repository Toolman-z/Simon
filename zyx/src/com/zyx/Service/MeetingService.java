package com.zyx.Service;
import java.util.List;

import com.zyx.Dao.MeetingDao;
import com.zyx.Model.Meeting;
import com.zyx.Model.Reservemeeting;
public class MeetingService {
private MeetingDao meetingDao=new MeetingDao();
	public String insert(Meeting meeting) {
		String rs=null;
		boolean boo = meetingDao.insert(meeting);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public String select(Meeting meeting) {		
					
		return	meetingDao.select(meeting);
	}
	public String insertid(String a, String meetingid) {
		return meetingDao.insertid(a,meetingid);
		
		
	}
	public List<Reservemeeting> query(Reservemeeting reservemeeting) {
		// TODO Auto-generated method stub
		return meetingDao.query(reservemeeting);
	}
	public String selectroomid(String roomname) {
		// TODO Auto-generated method stub
		return meetingDao.selectroomid(roomname);
	}
	public String selectemployeeid(String reservername) {
		// TODO Auto-generated method stub
		return meetingDao.selectemployeeid(reservername);
	}
	public int countquery(Reservemeeting reservemeeting) {
		// TODO Auto-generated method stub
		return meetingDao.selectcount(reservemeeting);
	}
	public String test(String id, String meetingid) {
		String rs=null;
		boolean boo = meetingDao.test(id,meetingid);
		System.out.println(boo);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public String insertchange(String id, String meetingid, String change) {
		String rs=null;
		boolean boo = meetingDao.insertchange(id,meetingid,change);
		System.out.println(boo);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}

}
