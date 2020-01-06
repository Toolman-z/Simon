package com.chinasofti.mapper.classroom;

import java.util.List;

import com.chinasofti.model.classroom.Classroom;
import com.chinasofti.model.classroom.Clazz;

public interface ClassroomMapper {
    int deleteByPrimaryKey(Integer classroomid);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer classroomid);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);

	List<Classroom> selectclassroom();

	List<Classroom> testclassroom(Classroom classroom);

	void addclassroom(Classroom classroom);

	List<Classroom> selectwhere(Classroom classroom);

	List<Classroom> selectclassroomthree(Classroom classroom);

	List<Classroom> selectclassroompeo(Classroom classroom);

	void editclassroom(Classroom classroom);

	void classstatus(Classroom classroom);


}