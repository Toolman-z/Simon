package com.zyx.Service;
import java.util.List;
import com.zyx.Dao.Dao;
import com.zyx.Dao.RegisterDao;
import com.zyx.Model.Employee;
import com.zyx.Model.Register;
import com.zyx.Model.Reservemeeting;
public class RegisterService {
private RegisterDao registerDao=new RegisterDao();
private Dao dao=new Dao(); 
	public List<Register> queryRegister() {		
		return registerDao.queryRegisters();
	}
	public Employee login(String username,String password) {
		Employee user=dao.login(username);
		if(user !=null && !user.getPassword().equals(password) ) {
			user=null;
		}
		return user;
	}
	public List<Register> query(String departmentid) {
		// TODO Auto-generated method stub
		return registerDao.query(departmentid);
	}
	public String repeat(String username) {
		// TODO Auto-generated method stub
		return registerDao.repeat(username);
	}
	public List<Reservemeeting> selectMeetingroom(String roomid, String meetingid) {
		// TODO Auto-generated method stub
		return dao.selectMeetingroom(roomid,meetingid);
	}
	public List<Employee> selectEmployee(String meetingid) {
		// TODO Auto-generated method stub
		return dao.selectmeetinguser(meetingid);
	}
	

}
