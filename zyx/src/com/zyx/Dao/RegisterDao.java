package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zyx.Model.Register;
import com.zyx.Util.DbUtil;
public class RegisterDao {

	public List<Register> queryRegisters() {
		List<Register> list =new ArrayList<Register>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from employee where status='0'";
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Register register =new Register();
				register =new Register();				
				register.setEmployeeid(Integer.parseInt(rs.getString("employeeid")));
				register.setRealname(rs.getString("realname"));
				register.setUsername(rs.getString("username"));
				register.setPassword(rs.getString("password"));
				register.setPhone(rs.getString("phone"));
				register.setEmail(rs.getString("email"));
				register.setDepartmentid(Integer.parseInt(rs.getString("departmentid")));
				register.setStatus(Integer.parseInt(rs.getString("status")));
				register.setRemark(rs.getString("remark"));
				register.setRole(Integer.parseInt(rs.getString("role")));
				list.add(register);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public boolean change(Register register) {
		boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("update employee set status='1' ");
		   sb.append("where employeeid='"+register.getEmployeeid()+"'");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		return boo;
	}

	public boolean delt(Register register) {
		boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("update employee set status='2' ");
		   sb.append("where employeeid='"+register.getEmployeeid()+"'");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		return boo;
	}

	public List<Register> query(String departmentid) {
		List<Register> list =new ArrayList<Register>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from employee where status='1' and departmentid='"+departmentid+"'";
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Register register =new Register();
				register =new Register();				
				register.setEmployeeid(Integer.parseInt(rs.getString("employeeid")));
				register.setRealname(rs.getString("realname"));
				register.setUsername(rs.getString("username"));
				register.setPassword(rs.getString("password"));
				register.setPhone(rs.getString("phone"));
				register.setEmail(rs.getString("email"));
				register.setDepartmentid(Integer.parseInt(rs.getString("departmentid")));
				register.setStatus(Integer.parseInt(rs.getString("status")));
				register.setRemark(rs.getString("remark"));
				register.setRole(Integer.parseInt(rs.getString("role")));
				list.add(register);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public String repeat(String username) {
		String user=null;
		DbUtil dbUtil=new DbUtil();
		Statement stm =dbUtil.getStatement();
		String sql="select * from employee where username ='"+username+"'";
		System.out.println(sql);
		try {
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				user=rs.getString("username");
				
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbUtil.closeConnection();
		return user;
	}

}
