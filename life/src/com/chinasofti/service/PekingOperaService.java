package com.chinasofti.service;
import com.chinasofti.dao.PekingOperaDao;
import com.chinasofti.model.PekingOpera;
public class PekingOperaService {	  	  
		private PekingOperaDao pkDao=new PekingOperaDao();
		public String select(PekingOpera pk) {
			String rs=null;
			String list="";
			list=pkDao.select(list);									
				rs="{'cmd':'601','code':'0','list':["+list+"]}";
				System.out.println(rs);							
			return rs;
			
		}
		
	}
