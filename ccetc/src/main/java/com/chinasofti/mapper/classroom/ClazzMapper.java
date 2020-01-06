package com.chinasofti.mapper.classroom;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.model.course.Course;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer clazzid);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer clazzid);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

	void addclazz(Clazz clazz);

	List<Clazz> selectCourse(Clazz clazz);

	List<Clazz> allclassroom();
}