package com.chinasofti.mapper.course;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.model.course.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	List<Course> selectCourse(HttpSession session,Clazz clazz);

	int insertcourse(Course course);

	List<Course> selectallCourse();

	int changecourse(Course course);
}