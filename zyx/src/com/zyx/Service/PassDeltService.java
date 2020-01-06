package com.zyx.Service;
import com.zyx.Dao.RegisterDao;
import com.zyx.Model.Register;
public class PassDeltService {
private RegisterDao registerDao=new RegisterDao();
	public String change(Register register) {
		String rs=null;
		boolean boo = registerDao.change(register);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}
	public String delt(Register register) {
		String rs=null;
		boolean boo = registerDao.delt(register);
		if(boo) {		
			rs="true";
		}else {
			rs="false";
		}
		return rs;
	}

}
