package com.chinasofti.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value= {"/home","/index"})
	public ModelAndView home(User u,HttpServletRequest req) { 
		System.err.println(req.getParameter("name"));
		System.out.println(u.getName()+","+u.getAge());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home");		
		return mav;
	}
	
}
