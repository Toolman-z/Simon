package com.chinasofti.mapper.region;

import java.util.List;

import com.chinasofti.model.region.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(String areaid);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(String areaid);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

	List<Region> areaList(Region region);

	List<Region> testareaname(Region region);

	void addarea(Region region);

	List<Region> selectAreaname(Region region);

	void editarea(Region region);

	List<Region> deltfive(Region region);

	int selectCount(Region region);

	List<Region> allareaList();

	
}