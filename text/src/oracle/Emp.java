package oracle;

import java.util.Date;

public class Emp {
private int empno;
private String ename;
private String job;
private int mgr;
private Date hiredate;
private double sal;
private double comm;
private int deptno;
public void setEmpno(int i) {
	// TODO Auto-generated method stub
	
}
public void setEname(String string) {
	// TODO Auto-generated method stub
	
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public int getMgr() {
	return mgr;
}
public void setMgr(int mgr) {
	this.mgr = mgr;
}
public Date getHiredate() {
	return hiredate;
}
public void setHiredate(Date i) {
	this.hiredate = i;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public double getComm() {
	return comm;
}
public void setComm(double comm) {
	this.comm = comm;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public int getEmpno() {
	return empno;
}
public String getEname() {
	return ename;
}

}
