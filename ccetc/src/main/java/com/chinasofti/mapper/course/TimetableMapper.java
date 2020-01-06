package com.chinasofti.mapper.course;

import java.util.List;

import com.chinasofti.model.course.Timetable;

public interface TimetableMapper {
    int deleteByPrimaryKey(Integer timetableid);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    Timetable selectByPrimaryKey(Integer timetableid);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);

	int inserttimetable(Timetable timetable);

	List<Timetable> selectALLtime(Timetable timetable);

	int killtimetable(Timetable timetable);

	List<Timetable> five(Timetable timetable);

	
}