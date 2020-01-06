package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.zyx.Model.Meetingroom;
import com.zyx.Util.DbUtil;
public class MeetingroomDao {
	
	public boolean insert(Meetingroom meetingroom) {
		  boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("insert into meetingroom(roomnum,capacity,roomname,status,remark) values(");
		   sb.append("'" + meetingroom.getRoomnum() + "',");
		   sb.append("'" + meetingroom.getCapacity() + "',");
		   sb.append("'" + meetingroom.getRoomname() + "',");
		   sb.append("'" + meetingroom.getStatus() + "',");
		   sb.append("'" + meetingroom.getRemark() + "')");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {
		  
		   boo = false;
		   e.printStackTrace();
		  }
		  return boo;
		 }

	public List<Meetingroom> queryMeetingrooms() {
		List<Meetingroom> list =new ArrayList<Meetingroom>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from meetingroom";
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Meetingroom meetingroom =new Meetingroom();
				meetingroom=new Meetingroom();
				meetingroom.setRoomnum(rs.getString("roomnum"));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setCapacity(Integer.parseInt(rs.getString("capacity")));
				meetingroom.setStatus(Integer.parseInt(rs.getString("status")));
				meetingroom.setRoomid(rs.getInt("roomid"));
				list.add(meetingroom);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
	}

	public List<Meetingroom> changeMeetingrooms(String roomid) {
		List<Meetingroom> list =new ArrayList<Meetingroom>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from meetingroom where roomid="+roomid+"";
		 System.out.println(sql);
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Meetingroom meetingroom =new Meetingroom();
				meetingroom=new Meetingroom();
				meetingroom.setRoomnum(rs.getString("roomnum"));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setCapacity(Integer.parseInt(rs.getString("capacity")));
				meetingroom.setStatus(Integer.parseInt(rs.getString("status")));
				meetingroom.setRemark(rs.getString("remark"));
				meetingroom.setRoomid(rs.getInt("roomid"));
				list.add(meetingroom);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	public boolean change(Meetingroom meetingroom) {
		 boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("update meetingroom set roomname='"+meetingroom.getRoomname()+"',");
		   sb.append("status='"+meetingroom.getStatus()+"',");
		   sb.append("remark='"+meetingroom.getRemark()+"',");
		   sb.append("capacity='"+meetingroom.getCapacity()+"',");
		   sb.append("roomnum='"+meetingroom.getRoomnum()+"' ");
		   sb.append("where roomid='"+meetingroom.getRoomid()+"'");
		   System.out.println(sb.toString());
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {
		  
		   boo = false;
		   e.printStackTrace();
		  }
		  return boo;
	}

	public List<Meetingroom> query(String startdate, String enddate) {
		List<Meetingroom> list =new ArrayList<Meetingroom>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库		
		 //SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// Date startDate=null;
		try {
			//startDate = sdf.parse(startdate);
			//Date enDate=sdf.parse(enddate);
			//System.out.println(startDate);
			//System.out.println(enDate);
			 StringBuffer sb = new StringBuffer();
			 sb.append("select * from meetingroom where roomid not in ");
			 sb.append("(select roomid from meeting where ");
			 sb.append("(meetingstarttime >= '"+startdate+"' and meetingstarttime <= '"+enddate+"') or");
			 sb.append(" (meetingstarttime <= '"+startdate+"' and meetingendtime >=' "+enddate+"') or");
			 sb.append(" (meetingendtime >= '"+startdate+"' and meetingendtime <=' "+enddate+"'))");
			ResultSet rs = stm.executeQuery(sb.toString());	
			System.out.println(sb);
			while(rs.next()) {
				Meetingroom meetingroom =new Meetingroom();
				meetingroom=new Meetingroom();				
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setRoomid(rs.getInt("roomid"));
				String a=meetingroom.getRoomname();
				System.out.println(a);
				list.add(meetingroom);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}	
}
