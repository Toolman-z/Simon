package com.chinasofti.service.system.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.mapper.system.RoleAuthMapper;
import com.chinasofti.service.system.RoleAuthService;

@Service
public class RoleAuthServiceImpl implements RoleAuthService {
	
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public List<String> authIdList(int roleId) {
		return roleAuthMapper.authIdList(roleId);
	}

	@Override
	public List<String> urlList(int roleid) {
		return roleAuthMapper.urlList(roleid);
	}

}
