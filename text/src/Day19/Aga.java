package Day19;

import java.util.HashSet;

public class Aga {
public static void main(String[]args) {
	HashSet<String>hs=new HashSet<String>();
	hs.add("������");
	hs.add("��������");
	System.out.println(hs.add("����"));
	hs.remove("������");
	hs.contains("��������");
	hs.isEmpty();
	hs.size();
	for(String s:hs) {
		System.out.println(s);
	}
	int[] x= {1,3,5,5,8,4,3,5,6,2,1};
}
}
