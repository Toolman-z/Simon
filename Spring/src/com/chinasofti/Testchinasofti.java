package com.chinasofti;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testchinasofti {
	@Test
	public void spring() {
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
		Boy boy=(Boy)ac.getBean("lwb");
		boy.speak(); 
		ac.close();
	}
}
