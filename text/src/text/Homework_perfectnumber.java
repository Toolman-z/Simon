package text;

public class Homework_perfectnumber {
	public static void main(String[]args) {
		//哪些是完数
				int d;
				int sum;
				int e;
				for(d=1;d<=100;d++) {
					sum=0;
					for(e=1;e<d;e++) {
						if(d%e==0) {
						sum+=e;
						}				
					}
					if(sum==d) {
						System.out.println(d+"是完数");
					}
			    }
	}

}
