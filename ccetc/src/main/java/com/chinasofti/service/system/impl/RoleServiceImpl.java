package com.chinasofti.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.chinasofti.mapper.system.RoleAuthMapper;
import com.chinasofti.mapper.system.RoleMapper;
import com.chinasofti.mapper.user.UserMapper;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.system.RoleAuth;
import com.chinasofti.service.system.RoleService;
import com.chinasofti.util.SessionUtil;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public List<Role> selectList() {
		List<Role> roleList = roleMapper.selectList();
		for (Role role : roleList) {
			role.setCount(userMapper.selectCountRole(role.getRoleid()));
		}
		return roleList;
	}

	@Override
	@Transactional
	public void insert(Role role, HttpSession session) {
		role.setCreateid(SessionUtil.userId(session));
		role.setCreatedate(new Date());
		roleMapper.insert(role);
		String[] authids = role.getAuthids().split(",");
		for(String authid : authids) {
			RoleAuth ra = new RoleAuth();
			ra.setRoleid(role.getRoleid());
			ra.setAuthid(authid);
			roleAuthMapper.insert(ra);
		}
	}

	@Override
	public Role selectRole(int roleid) {
		return roleMapper.selectByPrimaryKey(roleid);
	}

	@Override
	@Transactional
	public void update(Role role, HttpSession session) {
		role.setEditid(SessionUtil.userId(session));
		role.setEditdate(new Date());
		roleMapper.updateByPrimaryKey(role);
		roleAuthMapper.deleteByRoleId(role.getRoleid());
		String[] authids = role.getAuthids().split(",");
		for(String authid : authids) {
			RoleAuth ra = new RoleAuth();
			ra.setRoleid(role.getRoleid());
			ra.setAuthid(authid);
			roleAuthMapper.insert(ra);
		}
	}

	@Override
	@Transactional
	public void remove(Role role) {
		String[] roleids = role.getRoleids().split(",");
		for(String roleid : roleids) {
			roleAuthMapper.deleteByRoleId(Integer.parseInt(roleid));
			roleMapper.deleteByPrimaryKey(Integer.parseInt(roleid));
		}
	}

	@Override
	public List<Role> selectroll(Model model) {
		// TODO Auto-generated method stub
		return roleMapper.selectrole(model);
	}

}
