package com.chinasofti.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import com.chinasofti.db.DbUtil;
import com.chinasofti.model.User;

public class UserDao {
	public boolean select(User login) {		
			boolean boo =false;
			DbUtil dbUtil=new DbUtil();		
			Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		try {
			StringBuffer sb=new StringBuffer();
			sb.append("select * from user where ");
			sb.append("username='"+login.getName()+"' and ");
			sb.append("password='"+login.getPassword()+"'");			
			ResultSet rs = stm.executeQuery(sb.toString());
			while(rs.next()) {
				String name = rs.getString("username");
				String password =rs.getString("password");			
				System.out.println("账号："+name+"，密码"+password+".");	
				boo=true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return boo;
	}
	public boolean insert(User user) {
		  boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement statement = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("insert into user(username,password,uid) values(");
		   sb.append("'" + user.getName() + "',");
		   sb.append("'" + user.getPassword() + "',");
		   sb.append("'" + user.getUid() + "')");
		   statement.executeUpdate(sb.toString());
		  } catch (Exception e) {
		   // TODO: handle exception
		   boo = false;
		   e.printStackTrace();
		  }
		  return boo;
		 }	
}
