package Day13;

public class B extends Thread{
	private Person p;
	 B(Person person) {
	  p = person ;
	 }
	 
	 public void run () {
	  System.out.println("B�߳̽���");
	  p.eat();
	 }
}
