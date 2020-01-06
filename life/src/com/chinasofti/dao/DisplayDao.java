package com.chinasofti.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import com.chinasofti.db.DbUtil;
import com.chinasofti.model.Display;
public class DisplayDao {
	public boolean select(Display display) {		
		boolean boo =false;
		DbUtil dbUtil=new DbUtil();		
		Statement stm= dbUtil.getStatement();
		//和数据库建立连接，查询数据库
	try {
		StringBuffer sb=new StringBuffer();
		sb.append("select * from display");					
		ResultSet rs=stm.executeQuery(sb.toString());
		while(rs.next()) {
			String displayid = rs.getString("displayid");
			String name =rs.getString("name");	
			String time =rs.getString("time");
			String address =rs.getString("address");
			String image =rs.getString("image");
			display.setName(name);
			display.setTime(time);
			display.setAddress(address);
			display.setImagename(image);
			display.setDisplayid(displayid);
			System.out.println("displayid："+displayid+"，name"+name+",time:"+time+"address:"+address+"image:"+image+".");	
			boo=true;
		}
	} catch (Exception e) {
		boo =false;
		e.printStackTrace();
	}
	return boo;
}
}
