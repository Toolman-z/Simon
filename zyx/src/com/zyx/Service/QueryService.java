package com.zyx.Service;
import java.util.List;
import com.zyx.Dao.QueryDao;
import com.zyx.Model.Employee;
import com.zyx.Model.Meeting;
import com.zyx.Model.Register;
public class QueryService {
	private QueryDao queryDao= new QueryDao();
	public List<Register> query(String realname, int row, int page, String username, String status) {
		
		return queryDao.query(realname,row,page,username,status);
	}
	public String delet(Register register) {
		String rs=null;
		boolean boo = queryDao.delet(register);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public int countquery(String realname, String username, String status) {
		
		return queryDao.countquery(realname,username,status);
	}
	public List<Meeting> queryperson(String reserveuserid) {
		
		return queryDao.queryperson(reserveuserid);
	}
	public String selectroomname(String roomid) {
		// TODO Auto-generated method stub
		return queryDao.selectroomname1(roomid);
	}
	public List<Meeting> querypersonme(String reserveuserid) {
		// TODO Auto-generated method stub
		return queryDao.querypersonme(reserveuserid);
	}
	public List<Meeting> querydelete(String reserveuserid) {
		// TODO Auto-generated method stub
		return queryDao.querydelete(reserveuserid);
	}
	public List<Meeting> queryme(String reserveuserid) {
		// TODO Auto-generated method stub
		return queryDao.queryme(reserveuserid);
	}
	public List<Employee> querywho(String employeeid) {
		// TODO Auto-generated method stub
		return queryDao.querywho(employeeid);
	}
	public String changepwd(String employeeid, String pwd) {
		String rs=null;
		boolean boo = queryDao.changepwd(employeeid,pwd);
		System.out.println(boo);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}

}
