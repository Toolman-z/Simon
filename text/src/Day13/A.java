package Day13;

public class A extends Thread{
	private Person p;
	 A(Person person) {
	  p = person ;
	 }
	 
	 public void run () {
	  System.out.println("AÏß³Ì½áÊø");
	  p.eat();
	 }
}
