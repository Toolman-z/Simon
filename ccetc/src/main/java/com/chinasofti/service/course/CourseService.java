package com.chinasofti.service.course;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.model.course.Course;
import com.chinasofti.model.course.Timetable;


public interface CourseService {

	List<Clazz> selectCourse(HttpSession session,Clazz clazz);

	void sc(MultipartFile file, HttpSession session, Course course, Timetable timetable)throws Exception;

	List<Course> findallcourse();

	String exp(HttpSession session,Timetable timetable);

	void xg(MultipartFile file, HttpSession session, Course course, Timetable timetable)throws Exception;

	List<Timetable> five(Timetable timetable);



}
