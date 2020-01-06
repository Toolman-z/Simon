package com.chinasofti.service.user.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.mapper.system.RoleMapper;
import com.chinasofti.mapper.user.UserMapper;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;
import com.chinasofti.service.user.UserService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.SessionUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;


	@Override
	public User login(User user) {
		user.setPassword(Md5Util.md5(user.getPassword()));
		return userMapper.login(user);
	}

	@Override
	public List<User> selectList(User user) {
		return userMapper.selectList(user);
	}

	@Override
	public int selectCount(User user) {
		return userMapper.selectCount(user);
	}

	@Override
	public User selectByPrimaryKey(String userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	@Transactional
	public int update(User user, HttpSession session) {
		User u = userMapper.selectByPrimaryKey(user.getUserid());
		u.setRoleid(user.getRoleid());
		u.setStatus(user.getStatus());
		u.setEditid(SessionUtil.userId(session));
		u.setEditdate(new Date());
		return userMapper.updateByPrimaryKey(u);
	}

	@Override
	@Transactional
	public void updateStatus(String ids, int status, HttpSession session) {
		String[] values = ids.split(",");
		for(String id : values) {
			User u = userMapper.selectByPrimaryKey(id);
			u.setStatus(status);
			u.setEditid(SessionUtil.userId(session));
			u.setEditdate(new Date());
			userMapper.updateByPrimaryKey(u);
		}
	}

	@Override
	@Transactional
	public void updatePwd(String ids, HttpSession session) {
		String[] values = ids.split(",");
		for(String id : values) {
			User u = userMapper.selectByPrimaryKey(id);
			u.setPassword(Md5Util.md5("1234"));
			u.setEditid(SessionUtil.userId(session));
			u.setEditdate(new Date());
			userMapper.updateByPrimaryKey(u);
		}
	}

	@Override
	public void sc(MultipartFile file, HttpSession session,User user) throws Exception{
		int count = 0;
		if(!file.isEmpty()) {
		Workbook readwb =null;
		InputStream instream = file.getInputStream();
		readwb = Workbook.getWorkbook(instream);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();
		int rsRows = readsheet.getRows();
		for(int i=1;i<rsRows;i++) {			
			user.setCreatedate(new Date());
			user.setCreateid(SessionUtil.userId(session));
			for(int j=0;j<rsColumns;j++) {
				Cell cell = readsheet.getCell(j,i);
				System.out.println(cell.getContents());
				switch (j) {
				case 0:
					user.setUsername(cell.getContents());
					continue;
				case 1:
					user.setUserid(cell.getContents());
					continue;
				case 2:
					user.setPassword(Md5Util.md5(cell.getContents()));
					continue;
				case 3:
					if(cell.getContents().equals("男")) {
						user.setSex("0");
						
					}else if(cell.getContents().equals("女")){
						user.setSex("1");
						
					}					
					continue;
				case 4:
					if(cell.getContents().equals("全职")) {
						user.setProperties("1");
						
					}else if(cell.getContents().equals("兼职")){
						user.setProperties("0");
						
					}					
					continue;
				case 5:
					if(cell.getContents().equals("初级")) {
						user.setLevel("0");
						
					}else if(cell.getContents().equals("中级")){
						user.setLevel("1");
						
					}else if(cell.getContents().equals("高级")) {
						user.setLevel("2");
						
					}					
					continue;
				case 6:
					if(cell.getContents().equals("是")) {
						user.setTravel("0");
					}else {
						user.setTravel("1");
					}	
					System.out.println(user.getTravel());
					continue;
				case 7:
					user.setPhone(cell.getContents());
					continue;
				case 8:
					user.setWechat(cell.getContents());
					continue;
				case 9:
					user.setQq(cell.getContents());
					continue;
				case 10:
					user.setEmail(cell.getContents());
					continue;
				default:
					break;
				}
			}
			count = count + this.userMapper.insertSelectivebyex(user);
		}
		  }
		System.out.println(count);
		
	}

	@Override
	public List<User> selectall(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectall(user);
	}

	@Override
	public List<User> testusername(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(user);
	}

	@Override
	public void adduser(User user, HttpSession session) {
		// TODO Auto-generated method stub
		user.setCreatedate(new Date());
		user.setCreateid(SessionUtil.userId(session));
		user.setStatus(1);
		user.setPassword(Md5Util.md5(user.getPassword()));
		userMapper.adduser(user);
	}

	@Override
	public List<User> selecteditone(User user) {
		// TODO Auto-generated method stub
		return userMapper.selecteditone(user);
	}

	@Override
	public void edituser(User user, HttpSession session) {
		// TODO Auto-generated method stub
		user.setEditdate(new Date());
		user.setEditid(SessionUtil.userId(session));
		user.setStatus(1);
		userMapper.edituser(user);
	}

	@Override
	public List<User> childtwo(User user) {
		// TODO Auto-generated method stub
		return userMapper.childtwo(user);
	}

	@Override
	public List<User> selectrole() {
		// TODO Auto-generated method stub
		return userMapper.selectrole();
	}

	@Override
	public List<User> selectroletwo() {
		// TODO Auto-generated method stub
		return userMapper.selectroletwo();
	}

	@Override
	public List<User> childfour(User user) {
		// TODO Auto-generated method stub
		return userMapper.childfour(user);
	}

	@Override
	public List<User> childfive(User user) {
		// TODO Auto-generated method stub
		return userMapper.childfive(user);
	}

	@Override
	public int selectCountt(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectCountt(user);
	}

	@Override
	public void updateroleStatus(Role role, HttpSession session) {				
		role.setEditid(SessionUtil.userId(session));
		role.setEditdate(new Date());
			roleMapper.updateroleByPrimaryKey(role);
		}

	@Override
	public void removeuser(User user) {
		// TODO Auto-generated method stub
		userMapper.removeuser(user);
	}
	}	


