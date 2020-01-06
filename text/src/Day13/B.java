package Day13;

public class B extends Thread{
	private Person p;
	 B(Person person) {
	  p = person ;
	 }
	 
	 public void run () {
	  System.out.println("BÏß³Ì½áÊø");
	  p.eat();
	 }
}
