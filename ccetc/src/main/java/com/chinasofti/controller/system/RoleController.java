package com.chinasofti.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.system.Role;
import com.chinasofti.service.system.RoleService;
import com.chinasofti.util.MessageUtil;

@Controller
@RequestMapping("/system")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/role.action")
	public String role(Model model) {
		List<Role> roleList = roleService.selectList();
		model.addAttribute("roleList", roleList);
		return "system/role";
	}
	
	@RequestMapping("/roleAdd.action")
	public String roleAdd(Model model) {
		return "system/roleAdd";
	}
	
	@RequestMapping("/roleEdit.action")
	public String roleAdd(Model model, int roleid) {
		Role role = roleService.selectRole(roleid);
		model.addAttribute("role", role);
		return "system/roleEdit";
	}
	
	@RequestMapping("/roleInsert.action")
	@ResponseBody
	public String roleInsert(Role role,HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			roleService.insert(role, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/roleUpdate.action")
	@ResponseBody
	public String roleUpdate(Role role,HttpSession session) {
		MessageUtil msg = new MessageUtil();
		try {
			roleService.update(role, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/roleDelete.action")
	@ResponseBody
	public String roleDelete(Role role) {
		MessageUtil msg = new MessageUtil();
		try {
			roleService.remove(role);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("该角色已被使用，不可删除!");
		}
		return JSON.toJSONString(msg);
	}

}
