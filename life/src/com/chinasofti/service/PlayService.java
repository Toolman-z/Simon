package com.chinasofti.service;
import com.chinasofti.dao.PlayDao;
import com.chinasofti.model.Play;
public class PlayService {
	private PlayDao playDao=new PlayDao();
	public String select(Play play) {
		String rs=null;
		String list="";
		list=playDao.select(list);									
			rs="{'cmd':'701','code':'0','list':["+list+"]}";
			System.out.println(rs);							
		return rs;
		
	}
}
