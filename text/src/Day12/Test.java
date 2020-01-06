package Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
	public static void main(String[]args) {
  String a= "s";
  System.out.println(a.length());
  String b="hello";
  int[]c=new int[3];
  System.out.println(c[2]);
  System.out.println(b.charAt(4));
  int d=10;
  int f=0;
  try {
	  System.out.println(d/f);	  
  }catch(ArithmeticException e) {
	  System.out.println("aaaaaa出错了");
  }catch(NullPointerException e) {
	  
  }catch(ClassCastException e) {
	  
  }finally {
	  System.out.println("好了");
}
try {
	FileReader g=new FileReader(new File("d://a.txt"));
} catch (FileNotFoundException e) {	
	e.printStackTrace();
}
 Builder h=new Builder();
 try {
	System.out.println(h.buy());
} catch (NotFullException e) {	
	e.printStackTrace();
}
}
}