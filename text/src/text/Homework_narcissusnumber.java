package text;

public class Homework_narcissusnumber {
	public static void main(String[]args) {
	//水仙花数		
			int c;
			for(c=100;c<=500;c++){
			    int cca=c/100;
			    int ccb=(c%100)/10;
			    int ccc=c%10;
			    if(cca*cca*cca + ccb*ccb*ccb + ccc*ccc*ccc==c) {
			    	System.out.println(c+"是水仙花数");
			    }
			    //System.out.println((cca*cca*cca)+(ccb*ccb*ccb)+(ccc*ccc*ccc)==c? c+"是水仙花数":c+"不是水仙花数");
			                     }
	}
}
