package com.chinasofti.controller.system;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.chinasofti.model.Tree;
import com.chinasofti.service.system.AuthService;
@Controller
@RequestMapping("/system")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/authTree.action")
	@ResponseBody
	public String authTree() {
		List<Tree> tree = authService.selectTree();
		return JSON.toJSONString(tree);
	}
	
	@RequestMapping("/authEditTree.action")
	@ResponseBody
	public String authEditTree(Integer roleid) {
		List<Tree> tree = authService.selectEditTree(roleid);
		return JSON.toJSONString(tree);
	}

}
