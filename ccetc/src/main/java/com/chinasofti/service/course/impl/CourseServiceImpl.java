package com.chinasofti.service.course.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.chinasofti.mapper.classroom.ClazzMapper;
import com.chinasofti.mapper.course.CourseMapper;
import com.chinasofti.mapper.course.TimetableMapper;
import com.chinasofti.model.classroom.Clazz;
import com.chinasofti.model.course.Course;
import com.chinasofti.model.course.Timetable;
import com.chinasofti.service.course.CourseService;
import com.chinasofti.util.SessionUtil;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private TimetableMapper timetableMapper;
	

	@Autowired
	private ClazzMapper clazzMapper;
	@Override
	public List<Clazz> selectCourse(HttpSession session,Clazz clazz) {
		// TODO Auto-generated method stub
		clazz.setCreateid(SessionUtil.userId(session));
		System.out.println(clazz.getCreateid());
		return clazzMapper.selectCourse(clazz);
	}
	@Override
	public void sc(MultipartFile file, HttpSession session, Course course, Timetable timetable) throws Exception{
		// TODO Auto-generated method stub
		int count = 0;
		int countt=0;
		if(!file.isEmpty()) {
		Workbook readwb =null;
		InputStream instream = file.getInputStream();
		readwb = Workbook.getWorkbook(instream);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();
		int rsRows = readsheet.getRows();
		course.setCreatedate(new Date());
		course.setCreateid(SessionUtil.userId(session));
		countt= this.courseMapper.insertcourse(course);
		timetable.setClazzid(Integer.parseInt(course.getTechnologyid()));
		for(int i=1;i<rsRows;i++) {			
			
			for(int j=0;j<rsColumns;j++) {
				Cell cell = readsheet.getCell(j,i);
				System.out.println(cell.getContents());
				switch (j) {
				case 0:
					timetable.setDaysum(Integer.parseInt(cell.getContents()));
					continue;
				case 1:
					timetable.setContent(cell.getContents());
					continue;
			
				default:
					break;
				}
			}
			count = count + this.timetableMapper.inserttimetable(timetable);
		}
		  }
		System.out.println(count);
		System.out.println(countt);
	}
	@Override
	public List<Course> findallcourse() {
		// TODO Auto-generated method stub
		return courseMapper.selectallCourse();
	}
	
	@Override
	public String exp(HttpSession session,Timetable timetable) {
		String filePath = session.getServletContext().getRealPath("/") + "resources/file/downloads/users.xls";			
		List<Timetable> timetableList = timetableMapper.selectALLtime(timetable);
		List<String> head = Arrays.asList("时间", "课程内容");
		List<List<Object>> data = new ArrayList<List<Object>>();
		for (Timetable timetable1 : timetableList) {
			List<Object> objList = new ArrayList<Object>();
			objList.add(timetable1.getDaysum());
			objList.add(timetable1.getContent());
			data.add(objList);
		}
		writeSimpleBySheet(filePath, data, head);
		return filePath;
	}

	/**
	 * 生成excle
	 * 
	 * @param filePath 绝对路径
	 * @param data     数据源
	 * @param head     表头
	 */
	@SuppressWarnings("deprecation")
	public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head) {
		com.alibaba.excel.metadata.Sheet sheet = new com.alibaba.excel.metadata.Sheet(1, 0);
		sheet.setSheetName("数据");
		if (head != null) {
			List<List<String>> list = new ArrayList<>();
			head.forEach(h -> list.add(Collections.singletonList(h)));
			sheet.setHead(list);
		}

		OutputStream outputStream = null;
		ExcelWriter writer = null;
		try {
			outputStream = new FileOutputStream(filePath);
			writer = EasyExcelFactory.getWriter(outputStream);
			writer.write1(data, sheet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.finish();
				}

				if (outputStream != null) {
					outputStream.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void xg(MultipartFile file, HttpSession session, Course course, Timetable timetable) throws Exception{
		// TODO Auto-generated method stub
		int count =0;
		int countt=0;
		int counttt=0;
		if(!file.isEmpty()) {
		Workbook readwb =null;
		InputStream instream = file.getInputStream();
		readwb = Workbook.getWorkbook(instream);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();
		int rsRows = readsheet.getRows();
		course.setEditdate(new Date());
		course.setEditid(SessionUtil.userId(session));
		countt= this.courseMapper.changecourse(course);
		timetable.setClazzid(Integer.parseInt(course.getTechnologyid()));
		counttt=this.timetableMapper.killtimetable(timetable);
		for(int i=1;i<rsRows;i++) {			
			
			for(int j=0;j<rsColumns;j++) {
				Cell cell = readsheet.getCell(j,i);
				System.out.println(cell.getContents());
				switch (j) {
				case 0:
					timetable.setDaysum(Integer.parseInt(cell.getContents()));
					continue;
				case 1:
					timetable.setContent(cell.getContents());
					continue;
			
				default:
					break;
				}
			}
			
			count = count + this.timetableMapper.inserttimetable(timetable);
		}
		  }
		System.out.println(count);
		System.out.println(countt);
		System.out.println(counttt);
	}
	@Override
	public List<Timetable> five(Timetable timetable) {
		// TODO Auto-generated method stub
		return timetableMapper.five(timetable);
	}


}
