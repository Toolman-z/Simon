package com.zyx.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zyx.Model.Department;
import com.zyx.Util.DbUtil;
public class DepartmentDao {
	public boolean insert(Department department) {
		  boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("insert into department(departmentname) values(");
		   sb.append("'" + department.getDepartmentname() + "')");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		  return boo;
		 }

	public List<Department> queryMeetingrooms() {
		List<Department> list =new ArrayList<Department>();
		 DbUtil dbUtil = new DbUtil();
		 Statement stm= dbUtil.getStatement();
			//和数据库建立连接，查询数据库
		 String sql="select * from department";
		try {ResultSet rs = stm.executeQuery(sql);					
			while(rs.next()) {
				Department department =new Department();
				department =new Department();				
				department.setDepartmentname(rs.getString("departmentname"));
				department.setDepartmentid(Integer.parseInt(rs.getString("departmentid")));
				list.add(department);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public boolean change(Department department) {
		boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("update department set departmentname='"+department.getDepartmentname()+"' ");
		   sb.append("where departmentid='"+department.getDepartmentid()+"'");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		return boo;
	}

	public boolean delet(Department department) {
		boolean boo = true;
		  DbUtil dbUtil = new DbUtil();
		  // Connection connection = dbUtil.getConnection();
		  Statement stm = dbUtil.getStatement();
		  try {
		   StringBuffer sb = new StringBuffer();
		   sb.append("delete from department ");
		   sb.append("where departmentid='"+department.getDepartmentid()+"'");
		   stm.executeUpdate(sb.toString());
		  } catch (Exception e) {		  
		   boo = false;
		   e.printStackTrace();
		  }
		return boo;
	}
}
