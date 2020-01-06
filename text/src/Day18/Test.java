package Day18;
public class Test {
	public static void main(String[] args) {								
        int temp;
    	int date[] = {7,8,9,2,5,1,4,6,3,};
    	for(int i=0;i<date.length-1;i++) {  		
    		for(int j=0;j<date.length-i-1;j++) {
    			if(date[j]>date[j+1]) {
    				temp=date[j];
    				date[j]=date[j+1];
    				date[j+1]=temp;     				
    			}
    		}
    	}
    	for(int b:date) {
			System.out.print(b);
		}
    }
}
