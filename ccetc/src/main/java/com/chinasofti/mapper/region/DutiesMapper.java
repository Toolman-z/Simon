package com.chinasofti.mapper.region;

import java.util.List;

import com.chinasofti.model.region.Duties;

public interface DutiesMapper {
    int deleteByPrimaryKey(String dutiesid);

    int insert(Duties record);

    int insertSelective(Duties record);

    Duties selectByPrimaryKey(String dutiesid);

    int updateByPrimaryKeySelective(Duties record);

    int updateByPrimaryKey(Duties record);

	List<Duties> dutiesList(Duties duties);

	List<Duties> testdutiesname(Duties duties);

	void addduties(Duties duties);

	List<Duties> selecteditDuties(Duties duties);

	void editduties(Duties duties);

	List<Duties> selectAllDuties();

	List<Duties> childtwo(Duties duties);

	int selectCount(Duties duties);
}