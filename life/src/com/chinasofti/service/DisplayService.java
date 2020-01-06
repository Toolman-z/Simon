package com.chinasofti.service;
import com.chinasofti.dao.DisplayDao;
import com.chinasofti.model.Display;
public class DisplayService {	
		private DisplayDao displayDao=new DisplayDao();

		public String select(Display display) {
			
			boolean boo = displayDao.select(display);
			String rs=null;
			if(boo) {	
				System.out.println("找到了");
				rs="{'cmd':'401','code':'0','list':[{'did':'"+display.getDisplayid()+"'},{'name':'"+display.getName()+"'},{'time':'"+display.getTime()+"'},{'addr':'"+display.getAddress()+"'},{'image':'"+display.getImagename()+"'}]}";
			}else {
				System.out.println("没找到");
				rs="{'cmd':'401','code':'1'}";
			}
			return rs;
			
		}
	}

