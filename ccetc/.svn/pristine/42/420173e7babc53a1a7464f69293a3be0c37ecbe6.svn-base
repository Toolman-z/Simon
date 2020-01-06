package com.chinasofti.service.system.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.mapper.system.AuthMapper;
import com.chinasofti.mapper.system.RoleAuthMapper;
import com.chinasofti.model.Tree;
import com.chinasofti.model.system.Auth;
import com.chinasofti.service.system.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthMapper authMapper;
	
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public List<Auth> menuList() {
		return authMapper.menuList();
	}

	@Override
	public List<Tree> selectTree() {
		List<Auth> authList = authMapper.authListRoot();
		List<Tree> treeList = new ArrayList<Tree>();
		for (Auth auth : authList) {
			Tree tree = new Tree();
			tree.setId(auth.getAuthid());
			tree.setText(auth.getAuthname());
			if (auth.getChildren() != null && auth.getChildren().size() > 0) {
				tree.setChildren(this.treeList(auth.getChildren()));
			}
			treeList.add(tree);
		}
		return treeList;
	}

	private List<Tree> treeList(List<Auth> auths) {
		List<Tree> list = new ArrayList<Tree>();
		for (Auth auth : auths) {
			auth = authMapper.selectAuth(auth.getAuthid());
			Tree tree = new Tree();
			tree.setId(auth.getAuthid());
			tree.setText(auth.getAuthname());
			if (auth.getChildren() != null && auth.getChildren().size() > 0) {
				tree.setChildren(this.treeList(auth.getChildren()));
			}
			list.add(tree);
		}
		return list;
	}

	@Override
	public List<Tree> selectEditTree(Integer roleid) {
		List<String> authidList = roleAuthMapper.authIdList(roleid) ;
		List<Auth> authList = authMapper.authListRoot();
		List<Tree> treeList = new ArrayList<Tree>();
		for (Auth auth : authList) {
			Tree tree = new Tree();
			tree.setId(auth.getAuthid());
			tree.setText(auth.getAuthname());
			if (auth.getChildren() != null && auth.getChildren().size() > 0) {
				tree.setChildren(this.treeEditList(auth.getChildren(),authidList));
			}
			treeList.add(tree);
		}
		return treeList;
	}
	
	private List<Tree> treeEditList(List<Auth> auths, List<String> authidList) {
		List<Tree> list = new ArrayList<Tree>();
		for (Auth auth : auths) {
			auth = authMapper.selectAuth(auth.getAuthid());
			Tree tree = new Tree();
			tree.setId(auth.getAuthid());
			tree.setText(auth.getAuthname());
			if (auth.getChildren() != null && auth.getChildren().size() > 0) {
				tree.setChildren(this.treeEditList(auth.getChildren(),authidList));
			}else {
				if(authidList.contains(auth.getAuthid())) {
					tree.setChecked(true);
				}
			}
			list.add(tree);
		}
		return list;
	}

}
