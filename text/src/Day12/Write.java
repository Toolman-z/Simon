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
System.out.println("������Ҫ�����ˮ�����֣�");
String b=in.next();
System.out.println("��Ҫ���ˮ����"+b);
boolean isContains=Arrays.asList(a).contains(b);
if(isContains) {
	System.out.println("�����빺������");
	Scanner input=new Scanner(System.in);
	int g;
	g=input.nextInt();
	if(b==k) {
		if(g<h) {
			System.out.println("����ɹ�");
}else {
	System.out.println("��治��");
}
	}else {
		if(g<j) {
			System.out.println("����ɹ�");
}else {
	System.out.println("��治��");
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