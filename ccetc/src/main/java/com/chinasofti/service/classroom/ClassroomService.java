package com.chinasofti.service.classroom;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.classroom.Classroom;
import com.chinasofti.model.classroom.Clazz;

public interface ClassroomService {

	List<Classroom> selectClassroom();

	List<Classroom> testclassroomname(Classroom classroom);

	void insertclassroom(Classroom classroom, HttpSession session);

	List<Classroom> selectClassroomname(Classroom classroom);

	List<Classroom> selectClassroomthree(Classroom classroom);

	List<Classroom> testpeople(Classroom classroom);

	void addclazz(Clazz clazz, HttpSession session);

	void editclassroom(Classroom classroom, HttpSession session);

	List<Clazz> selectallclassroom(HttpSession session, Clazz clazz);

	void classstatus(Classroom classroom,HttpSession session);

	

}
