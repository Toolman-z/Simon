package Day17;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {
public static void main(String[]args) throws ParseException {
	Calendar a=Calendar.getInstance();
	System.out.println(a.get(Calendar.YEAR));
	System.out.println(a.get(Calendar.MONTH)+1 );
	System.out.println(a.get(Calendar.DAY_OF_MONTH));
	System.out.println(a.get(Calendar.HOUR));
	System.out.println(a.get(Calendar.MINUTE));
	System.out.println(a.get(Calendar.SECOND));
	Date b=new Date();
	SimpleDateFormat c=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String d=c.format(b);
    System.out.println(d);
    Date e =c.parse("1995-8-12 12:05:59");
    System.out.println(e);
    Locale q=new Locale("zh","CN");
    Locale w=new Locale("en","US");
    NumberFormat r=NumberFormat.getCurrencyInstance(q);
    NumberFormat t=NumberFormat.getCurrencyInstance(w);
    System.out.println(r.format(6446564));
    System.out.println(t.format(232311));
}
}
