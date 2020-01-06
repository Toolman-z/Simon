package com.chinasofti.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import com.chinasofti.db.DbUtil;

public class MusicDao {
	public String select(String list) {
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		//和数据库建立连接，查询数据库
		try {
			StringBuffer sb = new StringBuffer();
			StringBuffer sblist = new StringBuffer();
			sb.append("select * from music");
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				String musicid = rs.getString("musicid");
				String name = rs.getString("name");
				String time = rs.getString("time");
				String address = rs.getString("address");
				String image = rs.getString("image");
				/*
				 * {'cmd':'501','code':'0','list':[{'mid':'1','name':'千与千寻－久石让·宫崎骏动漫视听大型交响音乐会','
				 * image':'50001','time':'2012.06.02-2012.08.11','addr':'北京音乐厅'},{'mid':'2','
				 * name':'中国爱乐乐团2011-2012音乐季','image':'50002','time':'2011.03.17-2012.06.30','
				 * addr':'中山音乐堂'},{'mid':'3','name':'东方世纪行
				 * 》——世界风情音乐会','image':'50003','time':'常年','addr':'青蓝剧场'},{'mid':'4','name':'
				 * 放牛班的春天:法国圣-马可童声合唱团音乐会','image':'50004','time':'2012.10.19-2012.10.20','addr':
				 * '中山音乐堂'}]}
				 */
				sblist.append("{'mid':'" + musicid + "','name':'" + name + "','time':'" + time + "','addr':'"
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
