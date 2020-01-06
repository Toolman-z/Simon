package com.chinasofti.servlet;
import java.sql.ResultSet;
import java.sql.Statement;
public class Dao {		
	public boolean select(User login) {		
		boolean boo =false;
		DbUtil dbUtil=new DbUtil();				
	try {
		Statement stm= dbUtil.getStatement();
		String sql="select * from user where username ='"+login.getName()+"' and  password ='"+login.getPassword()+"'";
		ResultSet rs =stm.executeQuery(sql);
		while(rs.next()) {
			String name = rs.getString("username");
			String password =rs.getString("password");			
			System.out.println("’À∫≈£∫"+name+"£¨√‹¬Î"+password+".");	
			boo=true;
		}
		stm.close();		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return boo;
}
	public boolean insert(User zhuce) {	
		boolean boo =false;
		DbUtil dbUtil=new DbUtil();	
		try {
			Statement stm= dbUtil.getStatement();
			 StringBuffer sb = new StringBuffer();
			   sb.append("insert into user(username,password) values(");
			   sb.append("'" + zhuce.getName_z() + "',");
			   sb.append("'" + zhuce.getPassword_z() + "'");
			   sb.append(")");
			   boo=true;
			   stm.executeUpdate(sb.toString());
			
				
			
			stm.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boo;
	}
}