package Day09;

public class Test {
	public static void main(String[]args) {
		Lock lock=new FaceLock();
		lock.open();
		System.out.println("又关上了");
	}

}
