package Day14;
public class Test {
	
volatile boolean hasEggs=false;
Thread human=new Thread(()->{
	while(true) {
		if(!hasEggs) {
		System.out.println("�ȴ�");						
		}else {
			System.out.println("�ջ�");
			hasEggs=false;
		}
	}
});
Thread hen= new Thread(()->{
	while(true) {
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hasEggs=true;
	}
});

}
