package com.chinasofti.mapper.region;

import java.util.List;

import org.springframework.ui.Model;

import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;

public interface TechMapper {
    int deleteByPrimaryKey(String technologyid);

    int insert(Tech record);

    int insertSelective(Tech record);

    Tech selectByPrimaryKey(String technologyid);

    int updateByPrimaryKeySelective(Tech record);

    int updateByPrimaryKey(Tech record);

	List<Tech> selecttech(Model model);

	List<Tech> testtech(Tech tech);

	void techadd(Tech tech);

	List<Tech> selectone(Tech tech);

	List<Tech> testtechedit(Tech tech);

	void techaedit(Tech tech);

	List<Tech> childthree(Tech tech);

	List<Tech> findalltech(Tech tech);

	
}