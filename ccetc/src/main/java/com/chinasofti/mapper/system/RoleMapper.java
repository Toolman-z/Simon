package com.chinasofti.mapper.system;

import java.util.List;

import org.springframework.ui.Model;

import com.chinasofti.model.system.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> selectList();

	List<Role> selectrole(Model model);

	Role selectByPrimaryKey(String id);

	void updateroleByPrimaryKey(Role role);
}