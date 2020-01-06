package Day19;
public class Test {
	public static void main(String[]args) {
		int[] a= {9,8,7,3,2,1465,87,615,49,64,61,9,9,65,16,9,49,64,64};
		Test.maopao(a);
		for(int c:a) {
			System.out.print(c);
		}
	}
	public static void maopao(int[]b) {
		int a;
		for(int i=0;i<b.length-1;i++) {
			for(int j=0;j<b.length-i-1;j++) {
				if(b[j]>b[j+1]) {
				a=b[j];
				b[j]=b[j+1];
				b[j+1]=a;
			}
			}
		}
	}	
}
