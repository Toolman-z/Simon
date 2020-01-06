package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zyx.Model.Employee;
import com.zyx.Model.Meeting;
import com.zyx.Model.Register;
import com.zyx.Util.DbUtil;
public class QueryDao {

	public List<Register> query(String realname, int row, int page, String username, String status) {	
		List<Register> list =new ArrayList<Register>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from employee where status="+status+"");		
		 if(username !="" && realname !="") {
			 sql.append(" and realname='"+realname+"' and username='"+username+"'");
		 }else
		 if(username =="" && realname !=""){
			 sql.append(" and realname='"+realname+"'");
		 }else
		 if(username !="" && realname =="") {
			 sql.append(" and username='"+username+"'");
		 }else
		 if(username =="" && realname =="") {
			 sql.append("");
	     }
		 sql.append(" limit "+row*(page-1)+ "," +row);
		 System.out.println(sql);
		try {
			ResultSet rs = stm.executeQuery(sql.toString());
			System.out.println(rs);
			while(rs.next()) {				
				Register register1=new Register();
				register1.setRealname(rs.getString("realname"));
				register1.setUsername(rs.getString("username"));
				register1.setStatus(Integer.parseInt(rs.getString("status")));
				register1.setEmployeeid(Integer.parseInt(rs.getString("employeeid")));
				register1.setPassword(rs.getString("password"));
				register1.setPhone(rs.getString("phone"));
				register1.setEmail(rs.getString("email"));
				register1.setDepartmentid(Integer.parseInt(rs.getString("departmentid")));
				register1.setRole(Integer.parseInt(rs.getString("role")));
				register1.setRemark(rs.getString("remark"));
				list.add(register1);					
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	
	}

	public boolean delet(Register register) {
		boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("update employee set status=2 ");
		   sb.append("where employeeid='"+register.getEmployeeid()+"'");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		return boo;
	}

	public int countquery(String realname, String username, String status) {
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库						
		 StringBuffer sql=new StringBuffer("select count(*) as num from employee where status="+status+"");		
		 if(username !="" && realname !="") {
			 sql.append(" and realname='"+realname+"' and username='"+username+"'");
		 }else
		 if(username =="" && realname !=""){
			 sql.append(" and realname='"+realname+"'");
		 }else
		 if(username !="" && realname =="") {
			 sql.append(" and username='"+username+"'");
		 }else
		 if(username =="" && realname =="") {
			 
	     }
		 System.out.println(sql);
		 try {
			 ResultSet rs=stm.executeQuery(sql.toString());
			if(rs.next()) {
				return rs.getInt("num");
			}
		} catch (Exception e) {
			
		}
		return 0;
	}

	public String selectroomname(String roomid1) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select roomname from meetingroom where roomid='"+roomid1+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				li=rs.getString("roomname");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public String selectusername(String employeeid1) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select username from employee where employeeid='"+employeeid1+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				li=rs.getString("username");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public List<Meeting> queryperson(String reserveuserid) {
		System.out.println(reserveuserid);
		List<Meeting> list =new ArrayList<Meeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from meeting as a left join meetingroom as b on a.roomid=b.roomid left join meetinguser as c on a.meetingid=c.meetingid where a.meetingstarttime <= DATE_SUB(CURDATE(),INTERVAL -7 DAY) and CURDATE() <= a.meetingstarttime   and (reserveuserid='"+reserveuserid+"' or c.employeeid='"+reserveuserid+"') and meetingstatus='1' group by a.meetingname");	
		 System.out.println(sql);
		 
		 try {
				ResultSet rs = stm.executeQuery(sql.toString());
				System.out.println(rs);
				while(rs.next()) {				
					Meeting register1=new Meeting();
					register1.setMeetingname(rs.getString("meetingname"));
					register1.setRoomid(rs.getString("roomid"));
					register1.setMeetingstarttime(rs.getString("meetingstarttime"));
					register1.setMeetingendtime(rs.getString("meetingendtime"));					
					register1.setRoomname(rs.getString("roomname"));
					register1.setMeetingid(rs.getString("meetingid"));
					register1.setReservetime(rs.getString("reservetime"));
					list.add(register1);					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return list;
	}

	public String selectroomname1(String roomid) {
		String li="";
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		String sql = "select roomname from meetingname where roomid='"+roomid+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				li=rs.getString("roomname");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	public List<Meeting> querypersonme(String reserveuserid) {
		System.out.println(reserveuserid);
		List<Meeting> list =new ArrayList<Meeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from meeting as a left join meetingroom as b on a.roomid=b.roomid where reserveuserid='"+reserveuserid+"'");	
		 System.out.println(sql);
		 
		 try {
				ResultSet rs = stm.executeQuery(sql.toString());
				System.out.println(rs);
				while(rs.next()) {				
					Meeting register1=new Meeting();
					register1.setMeetingname(rs.getString("meetingname"));
					register1.setRoomid(rs.getString("roomid"));
					register1.setMeetingstarttime(rs.getString("meetingstarttime"));
					register1.setMeetingendtime(rs.getString("meetingendtime"));					
					register1.setRoomname(rs.getString("roomname"));
					register1.setMeetingid(rs.getString("meetingid"));
					register1.setReservetime(rs.getString("reservetime"));
					list.add(register1);					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return list;
	}

	public List<Meeting> querydelete(String reserveuserid) {
		System.out.println(reserveuserid);
		List<Meeting> list =new ArrayList<Meeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from meeting as a left join meetingroom as b on a.roomid=b.roomid where meetingstatus='2'");	
		 System.out.println(sql);
		 
		 try {
				ResultSet rs = stm.executeQuery(sql.toString());
				System.out.println(rs);
				while(rs.next()) {				
					Meeting register1=new Meeting();
					register1.setMeetingname(rs.getString("meetingname"));
					register1.setRoomid(rs.getString("roomid"));
					register1.setMeetingstarttime(rs.getString("meetingstarttime"));
					register1.setMeetingendtime(rs.getString("meetingendtime"));					
					register1.setRoomname(rs.getString("roomname"));
					register1.setMeetingid(rs.getString("meetingid"));
					register1.setReservetime(rs.getString("reservetime"));
					register1.setMeetingremark(rs.getString("meetingremark"));
					list.add(register1);					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return list;
	}

	public List<Meeting> queryme(String reserveuserid) {
		System.out.println(reserveuserid);
		List<Meeting> list =new ArrayList<Meeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from meetinguser as a "
		 		+ " left join meeting as b on a.meetingid=b.meetingid"
		 		+ " left join meetingroom as c on b.roomid=c.roomid"
		 		+ " left join employee as e on b.reserveuserid=e.employeeid"
		 		+ " where a.employeeid='"+reserveuserid+"' or b.reserveuserid='"+reserveuserid+"'  group by b.meetingname");	
		 System.out.println(sql);
		 
		 try {
				ResultSet rs = stm.executeQuery(sql.toString());
				System.out.println(rs);
				while(rs.next()) {				
					Meeting register1=new Meeting();
					register1.setMeetingname(rs.getString("meetingname"));
					register1.setRoomid(rs.getString("roomid"));
					register1.setMeetingstarttime(rs.getString("meetingstarttime"));
					register1.setMeetingendtime(rs.getString("meetingendtime"));					
					register1.setRoomname(rs.getString("roomname"));
					register1.setMeetingid(rs.getString("meetingid"));
					register1.setReservetime(rs.getString("reservetime"));
					register1.setMeetingremark(rs.getString("meetingremark"));
					register1.setRealname(rs.getString("realname"));
					list.add(register1);					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return list;
	}

	public List<Employee> querywho(String employeeid) {
		System.out.println(employeeid);
		List<Employee> list =new ArrayList<Employee>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库			 
		 StringBuffer sql=new StringBuffer("select * from employee where employeeid='"+employeeid+"'");	
		 System.out.println(sql);		 
		 try {
				ResultSet rs = stm.executeQuery(sql.toString());
				System.out.println(rs);
				while(rs.next()) {				
					Employee register1=new Employee();									
					register1.setRealname(rs.getString("realname"));
					list.add(register1);					
				}								
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return list;
	}

	public boolean changepwd(String employeeid, String pwd) {
		boolean boo = true;
		DbUtil dbUtil = new DbUtil();
		// Connection connection = dbUtil.getConnection();
		Statement stm = dbUtil.getStatement();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("update employee set password='"+pwd+"' where employeeid='"+employeeid+"'");			
			stm.executeUpdate(sb.toString());
		} catch (Exception e) {
			boo = false;
			e.printStackTrace();
		}
		return boo;
	}

	
		
	
}
