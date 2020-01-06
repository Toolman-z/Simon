package com.chinasofti.mapper.system;

import java.util.List;
import com.chinasofti.model.system.Auth;

public interface AuthMapper {
    int deleteByPrimaryKey(String authid);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(String authid);
    
    Auth selectAuth(String authid);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

	List<Auth> menuList();

	List<Auth> authListRoot();
}