package com.chinasofti.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;

import jxl.read.biff.BiffException;

public interface UserService {

	User login(User user);

	List<User> selectList(User user);

	int selectCount(User user);

	User selectByPrimaryKey(String userid);

	int update(User user, HttpSession session);

	void updateStatus(String ids, int status, HttpSession session);

	void updatePwd(String ids, HttpSession session);

	void sc(MultipartFile file, HttpSession session, User user)throws Exception;

	List<User> selectall(User user);

	List<User> testusername(User user);

	void adduser(User user, HttpSession session);

	List<User> selecteditone(User user);

	void edituser(User user, HttpSession session);

	List<User> childtwo(User user);

	List<User> selectrole();

	List<User> selectroletwo();

	List<User> childfour(User user);

	List<User> childfive(User user);

	int selectCountt(User user);

	void updateroleStatus(Role role, HttpSession session);

	void removeuser(User user);

	

}
