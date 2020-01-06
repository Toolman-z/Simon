package com.zyx.Service;
import java.util.List;
import com.zyx.Dao.DepartmentDao;
import com.zyx.Model.Department;
public class DepartmentService {
	private DepartmentDao departmentDao=new DepartmentDao();
	public String insert(Department department) {
		String rs=null;
		boolean boo = departmentDao.insert(department);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public List<Department> queryDepartment() {
	
		return departmentDao.queryMeetingrooms();
	}
	public String change(Department department) {
		String rs=null;
		boolean boo = departmentDao.change(department);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public String delet(Department department) {
		String rs=null;
		boolean boo = departmentDao.delet(department);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
}
