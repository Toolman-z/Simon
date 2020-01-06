package Day12;

import java.util.Scanner;

import java.util.Arrays;
public class Write {
	public static void main(String[]args) {
String[]a= {"apple","banana"};
int []apple= {100};
int []banana= {330};
int h=apple.length;
int j=banana.length;
String k="apple";
String l="banana";
Scanner in=new Scanner(System.in);
System.out.println("请输入要购买的水果名字：");
String b=in.next();
System.out.println("您要买的水果是"+b);
boolean isContains=Arrays.asList(a).contains(b);
if(isContains) {
	System.out.println("请输入购买数量");
	Scanner input=new Scanner(System.in);
	int g;
	g=input.nextInt();
	if(b==k) {
		if(g<h) {
			System.out.println("购买成功");
}else {
	System.out.println("库存不足");
}
	}else {
		if(g<j) {
			System.out.println("购买成功");
}else {
	System.out.println("库存不足");
}
	}
	
}else {
	Builder q=new Builder();
	 try {
		System.out.println(q.buy());
	} catch (NotFullException e) {	
		e.printStackTrace();
	}
}
}
}