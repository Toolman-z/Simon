package Day16;
import java.util.Arrays;
import java.util.Random;
public class Test {

	public static void main(String[] args) {
	String a="sdfsdf";
    System.out.println(a.indexOf("s",2));
    String value="11-22--33-44-ff";
    String[] ss=value.split("-");
    for(String s:ss) {
    	System.out.println(s);
    }
    Person p1=new Person("ÀîÀÚ",321);
    Person p2=new Person("º«Ã·Ã·",32);
    Person p3=new Person("ÀîÀÚÀà",325);
    Person[]b= {p1,p2,p3};
    Arrays.sort(b);
    for(Person p:b) {
    	System.out.println(p.getName());
    }
 
	}

}
