package com.chinasofti.mapper.user;

import java.util.List;

import com.chinasofti.model.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User login(User user);

	List<User> selectList(User user);

	int selectCount(User user);

	Integer selectCountRole(Integer roleid);

	int insertSelectivebyex(User user);

	List<User> selectall(User user);

	List<User> selectByPrimaryKey(User user);

	void adduser(User user);

	List<User> selecteditone(User user);

	void edituser(User user);

	List<User> childtwo(User user);

	List<User> selectrole();

	List<User> selectroletwo();

	List<User> childfour(User user);

	List<User> childfive(User user);

	int selectCountt(User user);

	void removeuser(User user);


}