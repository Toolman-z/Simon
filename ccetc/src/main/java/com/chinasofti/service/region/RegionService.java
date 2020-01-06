package com.chinasofti.service.region;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
public interface RegionService {

	List<Region> selectArea(Region region);

	List<Department> selectDepartment(Department department);

	List<Duties> selectDuties(Duties duties);

	void insertdept(Department department, HttpSession session);

	List<Region> testareaname(Region region);

	void insertarea(Region region, HttpSession session);

	List<Region> selectAreaname(Region region);

	void editarea(Region region, HttpSession session);

	List<Department> testdeptname(Department department);

	List<Department> selectDeptname(Department department);

	List<Department> testdepteditname(Department department);

	void editdept(Department department, HttpSession session);

	List<Department> selectDept();

	List<Duties> testdutiesname(Duties duties);

	void insertduties(Duties duties, HttpSession session);

	List<Duties> selecteditDuties(Duties duties);

	void editduties(Duties duties, HttpSession session);

	List<Duties> selectAllDuties();

	List<Department> childone(Department department);

	List<Duties> childtwo(Duties duties);

	List<Tech> selectTech(Model model);

	List<Tech> testtechname(Tech tech);

	void inserttech(Tech tech, HttpSession session);

	List<Tech> techeditjump(Tech tech);

	List<Tech> testtecheditname(Tech tech);

	void edittech(Tech tech, HttpSession session);

	List<Tech> childthree(Tech tech);

	List<Region> deltfive(Region region);

	int selectCount(Region region);

	int selectdeptCount(Department department);

	int selectdutiesCount(Duties duties);

	List<Region> selectAreaall();

	List<Tech> findalltech(Tech tech);





}
