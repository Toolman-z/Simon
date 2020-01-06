package Day10;



public class Day10 {
	public static void main(String[]args) {
StringBuffer sb=new StringBuffer("abcdefghijklmnopqrstovwxyz"); 
	sb=sb.reverse();
System.out.println(sb);

char[]s= {'a','b','c','d','e','f','g'};

for(int i=6;i>=0;i--) {
	System.out.print(s[i]);
}

for(int a=0;a<=10;a++) {
	System.out.println(" ");
	for(int b=0;b<=a;b++) {
		System.out.print("*");
	}
}
System.out.println("a a a a a ");
int[][]ss= {{1,3,5},{2,4,6},{8,0}};
for(int c=0;c<ss.length;c++) {
	int[]d=ss[c];
	for(int e=0;e<d.length;e++) {
		System.out.print(d[e]);
		
	}
	System.out.println(" ");
}
String x =new String("abc");
String y =new String("abc");
if(x.compareTo(y)>0) {
	System.out.println("x>0");
}
if(x.compareTo(y)==0) {
	System.out.println("x=y");
}
if(x.compareTo(y)<0) {
	System.out.println("x<y");
}
for(int f=10;f<=105;f++) {
	for(int g=2;g<f;g++) {
		if(f%g==0) {
			
			break;
		}else if(g==f-1){
			System.out.println(f+"ÊÇËØÊý");
			break;
		}
	}
}

}

}
