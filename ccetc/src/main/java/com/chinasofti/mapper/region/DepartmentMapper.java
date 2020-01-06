package com.chinasofti.mapper.region;
import java.util.List;
import com.chinasofti.model.region.Department;
public interface DepartmentMapper {
    int deleteByPrimaryKey(String deptid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String deptid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

	List<Department> departmentList(Department department);

	void adddept(Department department);

	List<Department> testdeptname(Department department);

	List<Department> selectDeptname(Department department);

	void editdept(Department department);

	List<Department> selectDept();

	List<Department> childone(Department department);

	int selectCount(Department department);

}