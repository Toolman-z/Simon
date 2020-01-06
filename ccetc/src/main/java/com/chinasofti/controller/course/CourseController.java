package com.chinasofti.controller.course;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.course.Course;
import com.chinasofti.model.course.Timetable;
import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.user.User;
import com.chinasofti.service.course.CourseService;
import com.chinasofti.service.region.RegionService;
import com.chinasofti.util.MessageUtil;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/course.action")
	public String areaTree(Tech tech,Model model) {//课程体系
		List<Tech> technology = regionService.findalltech(tech);//查询全部技术方向
		List<Course> course = courseService.findallcourse();//查询全部课程体系
		model.addAttribute("course", course);
		model.addAttribute("tech", technology);
		return "course/course";
		
	}
	
	@RequestMapping("/sc.action")
	public String usersc(MultipartFile file,HttpSession session,Model model,Tech tech,Course course,Timetable timetable) {
	
		try {
			courseService.sc(file,session,course,timetable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}		
		List<Tech> technology = regionService.findalltech(tech);//查询全部技术方向
		List<Course> coursee = courseService.findallcourse();//查询全部课程体系
		model.addAttribute("course", coursee);
		model.addAttribute("tech", technology);
		return "course/course";
	}
	
	@RequestMapping("/xg.action")
	public String userxg(MultipartFile file,HttpSession session,Model model,Tech tech,Course course,Timetable timetable) {
	
		try {
			courseService.xg(file,session,course,timetable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}		
		List<Tech> technology = regionService.findalltech(tech);//查询全部技术方向
		List<Course> coursee = courseService.findallcourse();//查询全部课程体系
		model.addAttribute("course", coursee);
		model.addAttribute("tech", technology);
		return "course/course";
	}
	
	@RequestMapping("/exp.action")
	@ResponseBody
	public String exp(HttpSession session,Timetable timetable) {//ex导出
		MessageUtil msg = new MessageUtil();
		try {
			String url = courseService.exp(session,timetable);
			msg.setMessage(url);
			msg.setSuccess(true);
		} catch (Exception e) {
			msg.setSuccess(false);
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}
	

	@RequestMapping("/five.action")
	@ResponseBody
	public String deltfive(Timetable timetable) {//五表联动
		System.out.println(timetable.getClazzid());
			List<Timetable> a=this.courseService.five(timetable);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
}
