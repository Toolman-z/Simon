package Day18;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
public class Homework {
	public static void main(String[] args) {		
		String[] aString = new String[] { "001", "009", "008", "004", "05", "7" };
		Map<Integer, String> aMap = new TreeMap<Integer, String>();
		for (int i = 0; i < aString.length; i++) {
			aMap.put(Integer.valueOf(aString[i]), aString[i]);
		}		
		for (Entry<Integer, String> entry : aMap.entrySet()) {
			System.out.println("value= " + entry.getValue());
		}
	}
}
