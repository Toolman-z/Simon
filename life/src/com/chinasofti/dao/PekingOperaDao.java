package com.chinasofti.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import com.chinasofti.db.DbUtil;
public class PekingOperaDao {
	public String select(String list) {
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		//和数据库建立连接，查询数据库
		try {
			StringBuffer sb = new StringBuffer();
			StringBuffer sblist = new StringBuffer();
			sb.append("select * from pekingopera");
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				String pekingopera_id = rs.getString("pekingopera_id");
				String name = rs.getString("name");
				String time = rs.getString("time");				
				String image = rs.getString("image");
				String address = rs.getString("address");
				sblist.append("{'pid':'" + pekingopera_id + "','name':'" + name + "','time':'" + time + "','addr':'"
						+ address + "','image':'" + image + "'},");
				System.out.println(sblist.toString());
			}
			list = sblist.toString();
			int idx = list.lastIndexOf(",");
			String str1 = list.substring(0, idx);
			list = str1;
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
}