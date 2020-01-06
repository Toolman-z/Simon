package Day17;


	public class Homework {

		public static void main(String args[]) {
			
			stringSplit("我ABC汉语DEF", 7);
			
		}

		public static void stringSplit(String str, int len) {
			
			if (str == null) {
				return;
			}

			if (len > str.length()) {
				len = str.length();
			}
			
			byte[] b = str.getBytes();
			
			if (b[len]<0) {
				String result = new String(b, 0, len--);
				System.out.println("截半结果为：" + result);
			} else {
				String result = new String(b, 0, len);
				System.out.println("结果为：" + result);
				
			}
		}

	}


