package com.chinasofti.controller.classroom;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.classroom.Classroom;
import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.user.User;
import com.chinasofti.service.classroom.ClassroomService;
import com.chinasofti.service.course.CourseService;
import com.chinasofti.service.region.RegionService;
import com.chinasofti.service.user.UserService;
import com.chinasofti.util.MessageUtil;

@Controller
@RequestMapping("/classroom")
public class classroomController {

	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/roomjump.action")
	public String areaTree(Model model) {//教室管理跳转
		List<Classroom> classroom = classroomService.selectClassroom();
		model.addAttribute("classroomList", classroom);
		return "classroom/classroom";
		
	}
	
	@RequestMapping("/nowclassroom.action")
	public String nowclassroom(Clazz clazz,HttpSession session,Model model) {//当前班级跳转		
		List<Clazz> courses = courseService.selectCourse(session,clazz);
		model.addAttribute("regionList", courses);		
		return "classroom/classroomnow";
		
	}
	

	@RequestMapping("/allclassroom.action")
	public String allclassroom(Clazz clazz,HttpSession session,Model model) {//所有班级跳转		
		List<Clazz> courses = classroomService.selectallclassroom(session,clazz);
		model.addAttribute("classroomList", courses);		
		return "classroom/allclassroom";
		
	}
	
	@RequestMapping("/roomaddjump.action")
	public String classTree(Model model,Region region) {//添加教室管理跳转
		List<Region> area = regionService.selectArea(region);
		model.addAttribute("areaList", area);
		return "classroom/addclassroom";
		
	}
	
	@RequestMapping("/classstatus.action")
	@ResponseBody
	public String classstatus(Model model,Classroom classroom,HttpSession session) {//开启关闭教室
		MessageUtil msg = new MessageUtil();
		System.out.println(classroom.getStatus());
		try {
			classroomService.classstatus(classroom, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
		
		
	
	
	@RequestMapping("/testclassroomname.action")
	@ResponseBody
	public String testareaname(Classroom classroom) {//添加时检测教室名是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Classroom> a=this.classroomService.testclassroomname(classroom);
			System.out.println(a);
			if(classroomService.testclassroomname(classroom).isEmpty()) {
				msg.setSuccess(false);
			}else {
				msg.setSuccess(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/Addclassroom.action")
	@ResponseBody
	public String areaadd(Classroom classroom,HttpSession session) {//添加教室
		MessageUtil msg = new MessageUtil();
		try {
			classroomService.insertclassroom(classroom, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	
	@RequestMapping("/classroomEditjump.action")
	public String roleAdd(Classroom classroom,Model model,Region region) {//修改教室跳转
		List<Classroom> classa = classroomService.selectClassroomname(classroom);
		List<Region> area = regionService.selectArea(region);
		model.addAttribute("areaList", area);
		System.out.println(classroom.getAreaid()); 
		model.addAttribute("classroom", classa);
		return "classroom/editclassroom";
	}
	
	@RequestMapping("/clazz.action")
	public String clazz(Model model,Region region) {//开班管理转
		List<Region> area = regionService.selectArea(region);//查询所有区域
		List<User> user = userService.selectrole();//查询班主任
		List<User> usert = userService.selectroletwo();//查询助教	
		model.addAttribute("List", area);
		model.addAttribute("userList", user);
		model.addAttribute("usertList", usert);
		return "classroom/clazz";
		
	}
	
	@RequestMapping("/childthree.action")
	@ResponseBody
	public String childtwo(Classroom classroom,Clazz clazz) {//三表联动	
		
		List<Classroom> classrooma = classroomService.selectClassroomthree(classroom);//查询教室
			System.out.println(classrooma);
			
			return JSON.toJSONString(classrooma);
	}
	
	@RequestMapping("/testpeople.action")
	@ResponseBody
	public String testpeople(Classroom classroom) {//添加用户名检测是否重复
			
			List<Classroom> a=this.classroomService.testpeople(classroom);
			System.out.println(a);
		
		return JSON.toJSONString(a);		
	}
	
	@RequestMapping("/addclazz.action")
	@ResponseBody
	public String clazzadd(Clazz clazz,HttpSession session) {//添加用户
		MessageUtil msg = new MessageUtil();
		System.out.println(clazz.getClazzmaster());
		try {
			classroomService.addclazz(clazz, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/classroomEdit.action")
	@ResponseBody
	public String duties(Classroom classroom,HttpSession session) {//修改教室
		MessageUtil msg = new MessageUtil();
		System.out.println(classroom.getAreaid());
		try {
			classroomService.editclassroom(classroom, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
}
