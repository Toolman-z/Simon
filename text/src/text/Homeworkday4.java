package text;

public class Homeworkday4 {

	public static void main(String[] args) {
		//������
		int a;
		int b;
		for(a=10;a<=105;a++) {
			for(b=2;b<a;b++) {
				if(a%b==0) {
							break;			
				}if(b==a-1){
					System.out.println(a+"������");
					
				}
			}
		}
        //ˮ�ɻ���		
		int c;
		for(c=100;c<=500;c++){
		    int cca=c/100;
		    int ccb=(c%100)/10;
		    int ccc=c%10;
		    if(cca*cca*cca + ccb*ccb*ccb + ccc*ccc*ccc==c) {
		    	System.out.println(c+"��ˮ�ɻ���");
		    }
		    //System.out.println((cca*cca*cca)+(ccb*ccb*ccb)+(ccc*ccc*ccc)==c? c+"��ˮ�ɻ���":c+"����ˮ�ɻ���");
		                     }
		//��Щ������
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
				System.out.println(d+"������");
			}
	    }
		//����
		int f;
		for(f=2000;f<=3000;f++) {
			if(f%4==0&f%100!=0|f%100==0&f%400==0) {
				System.out.println(f+"������");
			}
		}
		
		
		
	}	
}

