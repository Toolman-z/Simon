package Day15;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Test_three {
	public static void main(String[] args) {
		File f = new File("D:\\Tools\\aaa.txt");
		FileReader g = null;
		try {
			g = new FileReader(f);
			char [] d = new char[1024];
			int len = 0;
			while((len = g.read(d))!= -1) {
				System.out.println(new String(d,0,len));				
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			try {
				g.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	
}
