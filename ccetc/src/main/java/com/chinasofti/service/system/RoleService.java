package com.chinasofti.service.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.chinasofti.model.system.Role;

public interface RoleService {

	List<Role> selectList();

	void insert(Role role, HttpSession session);

	Role selectRole(int roleid);

	void update(Role role, HttpSession session);

	void remove(Role role);

	List<Role> selectroll(Model model);

}
