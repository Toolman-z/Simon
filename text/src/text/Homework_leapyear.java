package text;

public class Homework_leapyear {
	public static void main(String[]args) {
	//ÈòÄê
			int f;
			for(f=2000;f<=3000;f++) {
				if(f%4==0&f%100!=0|f%100==0&f%400==0) {
					System.out.println(f+"ÊÇÈòÄê");
				}
			}
	}
}
