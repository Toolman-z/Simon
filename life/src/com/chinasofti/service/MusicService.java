package com.chinasofti.service;
import com.chinasofti.dao.MusicDao;
import com.chinasofti.model.Music;
public class MusicService {	
		private MusicDao musicDao=new MusicDao();
		public String select(Music music) {
			String rs=null;
			String list="";
			list=musicDao.select(list);									
				rs="{'cmd':'501','code':'0','list':["+list+"]}";
				System.out.println(rs);							
			return rs;
			
		}
	}

