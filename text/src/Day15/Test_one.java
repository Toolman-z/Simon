package Day15;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Test_one {
	public static void writeIn(String c) {
		File a = new File("D:\\Tools\\aaa.txt");
		BufferedWriter b = null;
		try {
			b = new BufferedWriter(new FileWriter(a,true));
			b.write(c);
			b.newLine();
			b.flush();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}