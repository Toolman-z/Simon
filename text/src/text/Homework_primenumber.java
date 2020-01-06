package text;

public class Homework_primenumber {
	public static void main(String[]args) {
		//ËØÊı£»
				int a;
				int b;
				for(a=10;a<=105;a++) {
					for(b=2;b<a;b++) {
						if(a%b==0) {
									break;			
						}if(b==a-1){
							System.out.println(a+"ÊÇËØÊı");
							
						}
					}
				}
	}

}
