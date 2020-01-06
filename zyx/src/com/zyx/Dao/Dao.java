package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zyx.Model.Employee;
import com.zyx.Model.Reservemeeting;
import com.zyx.Util.DbUtil;
public class Dao {	
	public boolean insert(Employee zhuce) {	
		boolean boo =false;
		DbUtil dbUtil=new DbUtil();	
		try {
			Statement stm= dbUtil.getStatement();
			 StringBuffer sb = new StringBuffer();
			   sb.append("insert into employee(username,password,realname,phone,email,status,departmentid,role) values(");
			   sb.append("'" + zhuce.getUsername() + "',");
			   sb.append("'" + zhuce.getPassword() + "',");
			   sb.append("'" + zhuce.getRealname() + "',");
			   sb.append("'" + zhuce.getPhone() + "',");
			   sb.append("'" + zhuce.getEmail() + "',");
			   sb.append("'0',");
			   sb.append("'" + zhuce.getDepartmentid() + "',");
			   sb.append("'1'");
			   sb.append(")");			   
			   stm.executeUpdate(sb.toString());
			   boo=true;
			stm.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbUtil.closeConnection();
		}
		return boo;
	}
	public Employee login(String username) {
		Employee user=null;
		DbUtil dbUtil=new DbUtil();
		Statement stm =dbUtil.getStatement();
		String sql="select * from employee where username ='"+username+"' and status = 1";
		System.out.println(sql);
		try {
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				user=new Employee();
				user.setEmployeeid(rs.getInt("employeeid"));
				user.setRealname(rs.getString("realname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.closeConnection();
		}
		
		return user;
	}
	public List<Reservemeeting> selectMeetingroom(String roomid, String meetingid) {
		List<Reservemeeting> list =new ArrayList<Reservemeeting>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from meeting where roomid="+roomid+" and meetingid="+meetingid+"";
		 System.out.println(sql);
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Reservemeeting reservemeeting =new Reservemeeting();
				reservemeeting=new Reservemeeting();
				reservemeeting.setMeetingname(rs.getString("meetingname"));
				reservemeeting.setMeetingpersonnum(rs.getString("meetingpersonnum"));
				reservemeeting.setMeetingstarttime(rs.getString("meetingstarttime"));
				reservemeeting.setMeetingendtime(rs.getString("meetingendtime"));
				reservemeeting.setMeetingremark(rs.getString("meetingremark"));
				reservemeeting.setMeetingid(rs.getString("meetingid"));							
				list.add(reservemeeting);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	public List<Employee> selectmeetinguser(String meetingid) {
		List<Employee> list =new ArrayList<Employee>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select c.* from employee c,meetinguser d where d.meetingid='"+meetingid+"' and c.employeeid=d.employeeid ";
		 System.out.println(sql);
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Employee employee =new Employee();
				employee=new Employee();
				employee.setRealname(rs.getString("realname"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));										
				list.add(employee);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	
}
