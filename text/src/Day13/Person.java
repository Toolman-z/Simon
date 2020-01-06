package Day13;

public class Person {
	public synchronized void eat () {
		  
		  System.out.println(Thread.currentThread().getName()+"µ÷ÓÃeat£¨£©");
		  
		  try {
		   Thread.sleep(5000);
		  } catch (InterruptedException e) {
		   
		   e.printStackTrace();
		  }
		  
		  System.out.println(Thread.currentThread().getName()+"½áÊø");
		 }
}
