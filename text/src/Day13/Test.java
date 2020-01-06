package Day13;

public class Test {
public static void main(String[]args) {
	Person person = new Person() ;
	  Thread a = new A(person);
	  Thread b = new B(person);
	  //Thread c = new Thread(new C());
	  //a.setPriority(Thread.MAX_PRIORITY);
	  //b.setPriority(Thread.MIN_PRIORITY);
	  a.start();
	  b.start();
	  //c.start();
}
}
