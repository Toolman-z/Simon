package com.chinasofti.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.chinasofti.model.User;
@Controller
@RequestMapping("/user")
public class UserController {	
	@RequestMapping(value="/userAdd")
	public String userAdd(){			
		return "userAdd";				
	}	
	
		
		@RequestMapping(value="/addUser")
		public ModelAndView addUser(User user){
			ModelAndView mav=new ModelAndView();
			mav.addObject("user",user);
			mav.setViewName("userInfo");
			return mav;				
		}		
}
