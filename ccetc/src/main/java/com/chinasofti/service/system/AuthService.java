package com.chinasofti.service.system;

import java.util.List;

import com.chinasofti.model.Tree;
import com.chinasofti.model.system.Auth;

public interface AuthService {
	
	List<Auth> menuList();

	List<Tree> selectTree();

	List<Tree> selectEditTree(Integer roleid);

}
