package com.chinasofti.service.classroom.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mapper.classroom.ClassroomMapper;
import com.chinasofti.mapper.classroom.ClazzMapper;
import com.chinasofti.mapper.region.RegionMapper;
import com.chinasofti.model.classroom.Classroom;
import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.service.classroom.ClassroomService;
import com.chinasofti.util.SessionUtil;
@Service
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	private ClassroomMapper classroomMapper;
	
	
	@Autowired
	private ClazzMapper clazzMapper;
	
	@Override
	public List<Classroom> selectClassroom() {
		// TODO Auto-generated method stub
		return classroomMapper.selectclassroom();
	}


	@Override
	public List<Classroom> testclassroomname(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomMapper.testclassroom(classroom);
	}


	@Override
	public void insertclassroom(Classroom classroom, HttpSession session) {
		// TODO Auto-generated method stub
		classroom.setCreatedate(new Date());
		classroom.setCreateid(SessionUtil.userId(session));
		classroomMapper.addclassroom(classroom);
	}


	@Override
	public List<Classroom> selectClassroomname(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomMapper.selectwhere(classroom);
	}


	@Override
	public List<Classroom> selectClassroomthree(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomMapper.selectclassroomthree(classroom);
	}


	@Override
	public List<Classroom> testpeople(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomMapper.selectclassroompeo(classroom);
	}


	@Override
	public void addclazz(Clazz clazz, HttpSession session) {
		// TODO Auto-generated method stub
		clazz.setCreatedate(new Date());
		clazz.setCreateid(SessionUtil.userId(session));
		clazzMapper.addclazz(clazz);
	}


	@Override
	public void editclassroom(Classroom classroom, HttpSession session) {
		// TODO Auto-generated method stub
		classroom.setEditdate(new Date());
		classroom.setEditid(SessionUtil.userId(session));
		classroomMapper.editclassroom(classroom);
	}


	@Override
	public List<Clazz> selectallclassroom(HttpSession session, Clazz clazz) {
		// TODO Auto-generated method stub
		return clazzMapper.allclassroom();
	}


	@Override
	public void classstatus(Classroom classroom,HttpSession session) {
		// TODO Auto-generated method stub
		classroom.setEditdate(new Date());
		classroom.setEditid(SessionUtil.userId(session));
		classroomMapper.classstatus(classroom);
	}

}
