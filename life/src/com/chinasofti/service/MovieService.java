package com.chinasofti.service;
import com.chinasofti.dao.MovieDao;
import com.chinasofti.model.Movie;
public class MovieService {
	private MovieDao movieDao=new MovieDao();
	public String select(Movie movie) {
		String rs=null;
		String list="";
		list=movieDao.select(list);									
			rs="{'cmd':'101','code':'0','list':["+list+"]}";
			System.out.println(rs);							
		return rs;
		
	}
}
