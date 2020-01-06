package com.chinasofti.mapper.course;

import com.chinasofti.model.course.Timetable;

public interface TimetableMapper {
    int deleteByPrimaryKey(Integer timetableid);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    Timetable selectByPrimaryKey(Integer timetableid);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);
}