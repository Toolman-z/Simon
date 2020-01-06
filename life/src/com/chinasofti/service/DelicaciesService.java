package com.chinasofti.service;
import com.chinasofti.dao.DelicaciesDao;
import com.chinasofti.model.Delicacies;
public class DelicaciesService {
	private DelicaciesDao delicaciesDao=new DelicaciesDao();
	public String select(Delicacies delicacies) {
		String rs=null;
		String list="";
		list=delicaciesDao.select(list);									
			rs="{'cmd':'301','code':'0','list':["+list+"]}";
			System.out.println(rs);							
		return rs;		
	}
}
