package com.chinasofti.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import com.chinasofti.db.DbUtil;

public class MusicDao {
	public String select(String list) {
		DbUtil dbUtil = new DbUtil();
		Statement stm = dbUtil.getStatement();
		//�����ݿ⽨�����ӣ���ѯ���ݿ�
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
				 * {'cmd':'501','code':'0','list':[{'mid':'1','name':'ǧ��ǧѰ����ʯ�á����鿥�����������ͽ������ֻ�','
				 * image':'50001','time':'2012.06.02-2012.08.11','addr':'����������'},{'mid':'2','
				 * name':'�й���������2011-2012���ּ�','image':'50002','time':'2011.03.17-2012.06.30','
				 * addr':'��ɽ������'},{'mid':'3','name':'����������
				 * ����������������ֻ�','image':'50003','time':'����','addr':'�����糡'},{'mid':'4','name':'
				 * ��ţ��Ĵ���:����ʥ-���ͯ���ϳ������ֻ�','image':'50004','time':'2012.10.19-2012.10.20','addr':
				 * '��ɽ������'}]}
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
