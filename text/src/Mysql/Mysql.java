package Mysql;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
public class Mysql {
	@Test
 public void select(String name ) {
	 try {
		Class.forName("orcl.jdbc.driver.OracleDriver");//º”‘ÿ«˝∂Ø¿‡
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:mysql","root","orcl");
	} catch (Exception e) {		
		e.printStackTrace();
	}
 }
}
