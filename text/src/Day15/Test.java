package Day15;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
public class Test {
	public static void main(String[]args) throws IOException {
		File b = new File("D:\\Tools\\aaa.txt");
		System.out.println(b.exists());
	    FileInputStream in= null;
		try {		
		    in =new FileInputStream(b);
			byte[]d=new byte[5];
			int len=0;
			while((len=in.read(d))!=-1) {
				System.out.println(new String(d,0,len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    File f=new File("D:\\Tools\\aaa.txt");
	    FileOutputStream out = null;
	    try {
			out =new FileOutputStream(f);
			byte[]g="込込込込��込込込".getBytes();
			out.write(g);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (Exception e) {
			 e.printStackTrace();
			}
		}	    	      	     			      	       
	        File f1=new File("D:\\Tools\\aaa.txt");
	        File f2=new File("D:\\Tools\\1_copy.txt");
	        FileInputStream faa=null;
	        FileOutputStream fbb=null;

	      try {
	        faa= new FileInputStream(f1);
	        fbb= new FileOutputStream(f2);
	            
	        byte[] h=new byte[1000];
	        int len=100000;
	        while( (len = faa.read(h)) !=-1){
	            fbb.write(h,0,len);
	        }
	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }finally {
	        faa.close();
	        fbb.close();
	      }	    
	  File h= new File("D:\\Tools\\aaa.txt");
	  FileReader reader=null;
	  try {
		reader=new FileReader(h);
		char[]i=new char[2];
		int t=0;
		while((t=reader.read(i)) !=-1){
			System.out.println(new String(i,0,t));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

	}



