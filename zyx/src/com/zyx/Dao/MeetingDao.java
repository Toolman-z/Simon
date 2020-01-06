package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zyx.Model.Meeting;
import com.zyx.Model.Reservemeeting;
import com.zyx.Util.DbUtil;
public class MeetingDao {
	private QueryDao queryDao=new QueryDao();
	public boolean insert(Meeting meeting) {
		boolean boo = true;
		DbUtil dbUtil = new DbUtil();
		// Connection connection = dbUtil.getConnection();
		Statement stm = dbUtil.getStatement();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(
					"insert into meeting(meetingname,meetingpersonnum,meetingstarttime,meetingendtime,roomid,meetingremark,reserveuserid,meetingstatus,reservetime) values(");
			sb.append("'" + meeting.getMeetingname() + "',");
			sb.append("'" + meeting.getMeetingpersonnum() + "',");
			sb.append("'" + meeting.getMeetingstarttime() + "',");
			sb.append("'" + meeting.getMeetingendtime() + "',");
			sb.append("'" + meeting.getRoomid() + "',");
			sb.append("'" + meeting.getMeetingremark() + "',");
			sb.append("'" + meeting.getReserveuserid() + "',");
			sb.append("'1',");
			sb.append("'" + meeting.getReservetime() + "')");
			stm.executeUpdate(sb.toString());
		} catch (Exception e) {
			boo = false;
			e.printStackTrace();
		}
		return boo;
	}

	public String select(Meeting meeting) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select meetingid from meeting where meetingstatus='1' and meetingname='"
				+ meeting.getMeetingname() + "' and roomid='" + meeting.getRoomid() + "' and reserveuserid='"
				+ meeting.getReserveuserid() + "'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				li=rs.getString("meetingid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public String insertid(String a, String meetingid) {
		String boo = "";
		// select max(meeting) from meeting; 查询最大的id
		DbUtil dbUtil = new DbUtil();
		// Connection connection = dbUtil.getConnection();
		Statement stm = dbUtil.getStatement();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("insert into meetinguser(meetingid,employeeid) values(");
			sb.append("'" + meetingid + "',");
			sb.append("'" + a + "')");
			stm.executeUpdate(sb.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return boo;
	}

	public List<Reservemeeting> query(Reservemeeting reservemeeting) {
		List<Reservemeeting> list =new ArrayList<Reservemeeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库	
		 String meetingname=reservemeeting.getMeetingname();
		 String roomname=reservemeeting.getRoomname();
		 String reservername=reservemeeting.getReservername();
		 String reservefromdate=reservemeeting.getReservefromdate();//预定会议开始时间
		 String reservetodate=reservemeeting.getReservetodate();//预定会议结束时间
		 String meetingfromdate=reservemeeting.getMeetingfromdate();//会议开始时间
		 String meetingtodate=reservemeeting.getMeetingtodate();//会议结束时间
		 int page=reservemeeting.getPage();//当前页数
		 int row=10;//一页十行
		 StringBuffer sql=new StringBuffer("select * from meeting");		
		if(meetingname=="" && roomname=="" && reservername=="") {
			//如果查询的值全部为空的话 就查询所有信息
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"')");
		}else if(meetingname=="" && roomname=="" && reservername!="") {
			//查询条件只有预定者姓名有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname=="" && roomname!="" && reservername=="") {
			//查询条件只有会议室名称有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"'");
		}else if(meetingname!="" && roomname=="" && reservername=="") {
			//查询条件只有会议名称有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"'");
		}else if(meetingname=="" && roomname!="" && reservername!="") {
			//只有会议名称为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"' and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname!="" && roomname=="" && reservername!="") {
			//只有会议室名称为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"' and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname!="" && roomname!="" && reservername=="") {
			//只有预定者姓名为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"' and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"'");
		}
		 sql.append(" limit "+row*(page-1)+ "," +row);
		 System.out.println(sql);
		try {
			ResultSet rs = stm.executeQuery(sql.toString());			
			while(rs.next()) {	
				Reservemeeting reservemeeting1=new Reservemeeting();
				reservemeeting1.setMeetingid(rs.getString("meetingid"));
				reservemeeting1.setMeetingname(rs.getString("meetingname"));
				reservemeeting1.setMeetingpersonnum(rs.getString("meetingpersonnum"));
				reservemeeting1.setMeetingstarttime(rs.getString("meetingstarttime"));
				reservemeeting1.setMeetingendtime(rs.getString("meetingendtime"));
				reservemeeting1.setReservetime(rs.getString("reservetime"));
				reservemeeting1.setRoomid(rs.getString("roomid"));
				reservemeeting1.setMeetingremark(rs.getString("meetingremark"));
				reservemeeting1.setReserveuserid(rs.getString("reserveuserid"));
				reservemeeting1.setMeetingstatus(rs.getString("meetingstatus"));
				String roomid1=reservemeeting1.getRoomid();
				String employeeid1=reservemeeting1.getReserveuserid();
				String roomname1=queryDao.selectroomname(roomid1);
				String username=queryDao.selectusername(employeeid1);
				reservemeeting1.setRoomname(roomname1);
				reservemeeting1.setUsername(username);
				list.add(reservemeeting1);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public String selectroomid(String roomname) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select roomid from meetingroom where roomname='"+roomname+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				li=rs.getString("roomid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public String selectemployeeid(String reservername) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select employeeid from employee where username='"+reservername+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				li=rs.getString("employeeid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public int selectcount(Reservemeeting reservemeeting) {
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库	
		 String meetingname=reservemeeting.getMeetingname();
		 String roomname=reservemeeting.getRoomname();
		 String reservername=reservemeeting.getReservername();
		 String reservefromdate=reservemeeting.getReservefromdate();//预定会议开始时间
		 String reservetodate=reservemeeting.getReservetodate();//预定会议结束时间
		 String meetingfromdate=reservemeeting.getMeetingfromdate();//会议开始时间
		 String meetingtodate=reservemeeting.getMeetingtodate();//会议结束时间
		 int page=reservemeeting.getPage();//当前页数
		 int row=10;//一页十行
		 StringBuffer sql=new StringBuffer("select count(*) as num from meeting");		
		if(meetingname=="" && roomname=="" && reservername=="") {
			//如果查询的值全部为空的话 就查询所有信息
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"')");
		}else if(meetingname=="" && roomname=="" && reservername!="") {
			//查询条件只有预定者姓名有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname=="" && roomname!="" && reservername=="") {
			//查询条件只有会议室名称有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"'");
		}else if(meetingname!="" && roomname=="" && reservername=="") {
			//查询条件只有会议名称有值时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"'");
		}else if(meetingname=="" && roomname!="" && reservername!="") {
			//只有会议名称为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"' and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname!="" && roomname=="" && reservername!="") {
			//只有会议室名称为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"' and");
			sql.append(" reserveuserid='"+reservemeeting.getEmployeeid()+"'");
		}else if(meetingname!="" && roomname!="" && reservername=="") {
			//只有预定者姓名为空时
			sql.append(" where (meetingstarttime >='"+meetingfromdate+"' and meetingstarttime <='"+meetingtodate+"') and");		
			sql.append(" (meetingendtime >='"+meetingfromdate+"' and meetingendtime <='"+meetingtodate+"') and");
			sql.append(" (reservetime >='"+reservefromdate+"' and reservetime <='"+reservetodate+"') and");
			sql.append(" meetingname='"+meetingname+"' and");
			sql.append(" roomid='"+reservemeeting.getRoomid()+"'");
		}
		 
		 System.out.println(sql);
		try {
			ResultSet rs = stm.executeQuery(sql.toString());			
			if(rs.next()) {
				return rs.getInt("num");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public boolean test(String id, String meetingid) {
		boolean boo = false;
		DbUtil dbUtil = new DbUtil();
		// Connection connection = dbUtil.getConnection();
		Statement stm = dbUtil.getStatement();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from meeting where reserveuserid='"+id+"' and meetingid='"+meetingid+"'");			
			ResultSet rs=stm.executeQuery(sb.toString());
			System.out.println(rs);
			if(rs.next()) {
			boo =true;
			}
		} catch (Exception e) {
			boo = false;
			e.printStackTrace();
		}
		return boo;
	}

	public boolean insertchange(String id, String meetingid, String change) {
		boolean boo = true;
		DbUtil dbUtil = new DbUtil();
		// Connection connection = dbUtil.getConnection();
		Statement stm = dbUtil.getStatement();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("update meeting set meetingremark='"+change+"' , meetingstatus='2' where meetingid='"+meetingid+"' and reserveuserid='"+id+"'");			
			stm.executeUpdate(sb.toString());
		} catch (Exception e) {
			boo = false;
			e.printStackTrace();
		}
		return boo;
	}

}
