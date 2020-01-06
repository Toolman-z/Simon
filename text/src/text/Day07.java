package text;
import java.util.Date;
public class Day07 {
	public static void main(String[]args) {
		Bird bird=new Bird();
		bird.setName();
		System.out.println(bird.getName());
		C c=new C();
		System.out.println(c.a(1, 2, 3));
		Date date=new Date();
		System.out.println(date.toLocaleString());
	}

}
