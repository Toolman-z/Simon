package com.chinasofti.service.region.impl;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chinasofti.mapper.region.DepartmentMapper;
import com.chinasofti.mapper.region.DutiesMapper;
import com.chinasofti.mapper.region.RegionMapper;
import com.chinasofti.mapper.region.TechMapper;
import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
import com.chinasofti.service.region.RegionService;
import com.chinasofti.util.SessionUtil;
@Service
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionMapper regionMapper;
	
	@Autowired
	private DepartmentMapper depMapper;
	
	@Autowired
	private DutiesMapper dutiesMapper;
	
	@Autowired
	private TechMapper techMapper;

	@Override
	public List<Region> selectArea(Region region) {
		
		return regionMapper.areaList(region);
	}

	@Override
	public List<Department> selectDepartment(Department department) {
		
		return depMapper.departmentList(department);
	}

	@Override
	public List<Duties> selectDuties(Duties duties) {
		
		return dutiesMapper.dutiesList(duties);
	}

	@Override
	public void insertdept(Department department, HttpSession session) {
		department.setCreatedate(new Date());
		department.setCreateid(SessionUtil.userId(session));
		depMapper.adddept(department);
	}

	@Override
	public List<Region> testareaname(Region region) {
		
		return regionMapper.testareaname(region);
		
	}

	@Override
	public void insertarea(Region region, HttpSession session) {
		region.setCreatedate(new Date());
		region.setCreateid(SessionUtil.userId(session));
		regionMapper.addarea(region);
	}

	@Override
	public List<Region> selectAreaname(Region region) {
		// TODO Auto-generated method stub
		return regionMapper.selectAreaname(region);
	}

	@Override
	public void editarea(Region region, HttpSession session) {
		region.setEditdate(new Date());
		region.setEditid(SessionUtil.userId(session));
		regionMapper.editarea(region);
	}

	@Override
	public List<Department> testdeptname(Department department) {
		// TODO Auto-generated method stub
		return depMapper.testdeptname(department);
	}

	@Override
	public List<Department> selectDeptname(Department department) {
		// TODO Auto-generated method stub
		return depMapper.selectDeptname(department);
	}

	@Override
	public List<Department> testdepteditname(Department department) {
		// TODO Auto-generated method stub
		return depMapper.testdeptname(department);
	}

	@Override
	public void editdept(Department department, HttpSession session) {
		department.setEdirtdate(new Date());
		department.setEditid(SessionUtil.userId(session));
		depMapper.editdept(department);
		
	}

	@Override
	public List<Department> selectDept() {
		// TODO Auto-generated method stub
		return depMapper.selectDept();
	}

	@Override
	public List<Duties> testdutiesname(Duties duties) {
		// TODO Auto-generated method stub
		return dutiesMapper.testdutiesname(duties);
	}

	@Override
	public void insertduties(Duties duties, HttpSession session) {
		duties.setCreatedate(new Date());
		duties.setCreateid(SessionUtil.userId(session));
		dutiesMapper.addduties(duties);
	}

	@Override
	public List<Duties> selecteditDuties(Duties duties) {
		// TODO Auto-generated method stub
		return dutiesMapper.selecteditDuties(duties);
	}

	@Override
	public void editduties(Duties duties, HttpSession session) {
		duties.setEditdate(new Date());
		duties.setEditid(SessionUtil.userId(session));
		dutiesMapper.editduties(duties);
	}

	@Override
	public List<Duties> selectAllDuties() {
		// TODO Auto-generated method stub
		return dutiesMapper.selectAllDuties();
	}

	@Override
	public List<Department> childone(Department department) {
		// TODO Auto-generated method stub
		return depMapper.childone(department);
	}

	@Override
	public List<Duties> childtwo(Duties duties) {
		// TODO Auto-generated method stub
		return dutiesMapper.childtwo(duties);
	}

	@Override
	public List<Tech> selectTech(Model model) {
		// TODO Auto-generated method stub
		return techMapper.selecttech(model);
	}

	@Override
	public List<Tech> testtechname(Tech tech) {
		// TODO Auto-generated method stub
		return  techMapper.testtech(tech);
	}

	@Override
	public void inserttech(Tech tech, HttpSession session) {
		// TODO Auto-generated method stub
		tech.setCreatedate(new Date());
		tech.setCreateid(SessionUtil.userId(session));
		techMapper.techadd(tech);
	}

	@Override
	public List<Tech> techeditjump(Tech tech) {
		// TODO Auto-generated method stub
		return techMapper.selectone(tech);
	}

	@Override
	public List<Tech> testtecheditname(Tech tech) {
		// TODO Auto-generated method stub
		return techMapper.testtechedit(tech);
	}

	@Override
	public void edittech(Tech tech, HttpSession session) {
		// TODO Auto-generated method stub
		tech.setEditdate(new Date());
		tech.setEditid(SessionUtil.userId(session));
		techMapper.techaedit(tech);
	}

	@Override
	public List<Tech> childthree(Tech tech) {
		// TODO Auto-generated method stub
		return techMapper.childthree(tech);
	}

	@Override
	public List<Region> deltfive(Region region) {
		// TODO Auto-generated method stub
		return regionMapper.deltfive(region);
	}

	@Override
	public int selectCount(Region region) {
		// TODO Auto-generated method stub
		return regionMapper.selectCount(region);
	}

	@Override
	public int selectdeptCount(Department department) {
		// TODO Auto-generated method stub
		return depMapper.selectCount(department);
	}

	@Override
	public int selectdutiesCount(Duties duties) {
		// TODO Auto-generated method stub
		return dutiesMapper.selectCount(duties);
	}

	@Override
	public List<Region> selectAreaall() {
		// TODO Auto-generated method stub
		return regionMapper.allareaList();
	}

	@Override
	public List<Tech> findalltech(Tech tech) {
		// TODO Auto-generated method stub
		return techMapper.findalltech(tech);
	}




}
