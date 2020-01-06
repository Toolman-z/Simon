package com.chinasofti.service;
import com.chinasofti.dao.ConcertDao;
import com.chinasofti.model.Concert;
public class ConcertService {	
		private ConcertDao concertDao=new ConcertDao();
		public String select(Concert concert) {
			String rs=null;
			String list="";
			list=concertDao.select(list);									
				rs="{'cmd':'201','code':'0','list':["+list+"]}";
				System.out.println(rs);							
			return rs;
			
		}
	}

