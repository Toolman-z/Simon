package com.chinasofti.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;
import com.chinasofti.service.region.RegionService;
import com.chinasofti.service.system.RoleService;
import com.chinasofti.service.user.UserService;
import com.chinasofti.util.MessageUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RegionService regionService;

	@RequestMapping("/userRole.action")
	public String userRole(Model model,@ModelAttribute("user")User user) {
		List<User> userList = userService.selectList(user);
		int total = userService.selectCount(user);
		model.addAttribute("userList", userList);
		model.addAttribute("total", total);
		return "user/userRole";
	}
	
	@RequestMapping("/user.action")
	public String user(Model model,@ModelAttribute("user")User user) {
		List<User> userList = userService.selectall(user);
		List<Region> area = regionService.selectAreaall();//查询所有的区域
		List<Department> dept =regionService.selectDept();//查询所有的部门
		List<Duties> duties =regionService.selectAllDuties();//查询所有职务
		int total = userService.selectCountt(user);
		model.addAttribute("total", total);
		model.addAttribute("dutiesList", duties);
		model.addAttribute("areaList", area);
		model.addAttribute("deptList", dept);
		model.addAttribute("userList", userList);
		return "user/user";
	}
	
	@RequestMapping("/sc.action")
	public String usersc(MultipartFile file,HttpSession session,Model model,@ModelAttribute("user")User user,Region region) {
	
		System.out.println(user.getAreaid());
		try {
			userService.sc(file,session,user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		List<User> userList = userService.selectall(user);
		List<Region> area = regionService.selectArea(region);//查询所有的区域
		List<Department> dept =regionService.selectDept();//查询所有的部门
		List<Duties> duties =regionService.selectAllDuties();//查询所有职务
		int total = userService.selectCount(user);
		model.addAttribute("total", total);
		model.addAttribute("dutiesList", duties);
		model.addAttribute("areaList", area);
		model.addAttribute("deptList", dept);
		model.addAttribute("userList", userList);
		return "user/user";
	}
	
	@RequestMapping("/changepwd.action")
	public String changepwd() {
		
		return "user/changepwd";
	}
	@RequestMapping("/userRoleEdit.action")
	public String userRoleEdit(Model model,String userid) {
		User user = userService.selectByPrimaryKey(userid);
		List<Role> roleList = roleService.selectList();
		model.addAttribute("user", user);
		model.addAttribute("roleList", roleList);
		return "user/userRoleEdit";
	}

	@RequestMapping("/login.action")
	@ResponseBody
	public String login(User user, HttpSession session) {
		User u = userService.login(user);
		MessageUtil msg = new MessageUtil();
		if(u != null) {
			session.setAttribute("user", u);
			msg.setSuccess(true);
		}else {
			msg.setSuccess(false);
			msg.setMessage("账号或密码错误");
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/userRoleUpdate.action")
	@ResponseBody
	public String userRoleUpdate(User user, HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			userService.update(user, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/userUpdateStatus.action")
	@ResponseBody
	public String userUpdateStatus(String ids, int status, HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			userService.updateStatus(ids, status, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}
	
	
	@RequestMapping("/userUpdateroleStatus.action")
	@ResponseBody
	public String userUpdateroleStatus(Role role, HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			userService.updateroleStatus(role,session);
			msg.setSuccess(true);
		}catch(Exception e) {
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/userUpdatePwd.action")
	@ResponseBody
	public String userUpdatePwd(String ids, HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			userService.updatePwd(ids, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}

	@RequestMapping("/userAddJump.action")
	public String useradd(Model model,Region region) {
		List<Region> area = regionService.selectArea(region);//添加时查询所有的区域
		List<Department> dept =regionService.selectDept();//添加时查询所有的部门
		List<Tech> tech = regionService.selectTech(model);//添加时查询所有技术方向
		List<Role> role = roleService.selectroll(model);//添加时查询所有角色
		model.addAttribute("roleList", role);
		model.addAttribute("techList", tech);
		model.addAttribute("List", area);
		model.addAttribute("deptList", dept);
		return "user/useradd";
	}
	
	@RequestMapping("/testusername.action")
	@ResponseBody
	public String testusername(User user) {//添加用户名检测是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<User> a=this.userService.testusername(user);
			System.out.println(a);
			if(userService.testusername(user).isEmpty()) {
				msg.setSuccess(true);
			}else {
				msg.setSuccess(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/adduser.action")
	@ResponseBody
	public String areaadd(User user,HttpSession session) {//添加用户
		MessageUtil msg = new MessageUtil();
		try {
			userService.adduser(user, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/userEditjump.action")
	public String roleAdd(User user,Model model,Region region) {//修改用户跳转
		List<User> use = userService.selecteditone(user);
		List<Region> area = regionService.selectArea(region);//查询所有的区域
		List<Role> role = roleService.selectroll(model);//查询所有角色
		model.addAttribute("roleList", role);
		model.addAttribute("List", area);
		model.addAttribute("user", use);
		return "user/useredit";
	}
	
	@RequestMapping("/edituser.action")
	@ResponseBody
	public String edituser(User user,HttpSession session) {//修改用户
		MessageUtil msg = new MessageUtil();
		try {
			userService.edituser(user, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/childtwo.action")
	@ResponseBody
	public String childtwo(User user) {//三表联动		
			List<User> a=this.userService.childtwo(user);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	
	@RequestMapping("/childfour.action")
	@ResponseBody
	public String childfour(User user) {//四表联动		
			List<User> a=this.userService.childfour(user);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	
	@RequestMapping("/childfive.action")
	@ResponseBody
	public String childfive(User user) {//五表联动		
			List<User> a=this.userService.childfive(user);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	@RequestMapping("/removeuser.action")
	@ResponseBody
	public String removeuser(User user) {
		MessageUtil msg = new MessageUtil();
		try {
			userService.removeuser(user);
			msg.setSuccess(true);
		}catch(Exception e) {
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
	}
}
