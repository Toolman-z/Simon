package oracle;
import java.sql.Statement;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;
public class db {
private static final Statement stm = null;
private static final Statement con = null;
public void select(String name,String deptno) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","orcl");
		Statement stm = con.createStatement();
		String sql="select * from emp where deptno ='"+deptno+"' or  ename like'"+name+"%'";
		ResultSet rs =stm.executeQuery(sql);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename =rs.getString("ename");
			Date hir =rs.getDate("hiredate");
			System.out.println("工号："+empno+"，姓名"+ename+",入职日期"+hir.toLocaleString());			
		}
		stm.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
@Test
public void query() {
	select("S","20");
}
@Test
public void insert() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","orcl");
		Statement stm = con.createStatement();
		String sql="insert into emp(empno,ename) Values(1002,'中国冬冬')";
		stm.executeUpdate(sql);
		ResultSet rs =stm.executeQuery(sql);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename =rs.getString("ename");
			Date hir =rs.getDate("hiredate");
			System.out.println("工号："+empno+"，姓名"+ename+",入职日期"+hir.toLocaleString());			
		}
		stm.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
}
