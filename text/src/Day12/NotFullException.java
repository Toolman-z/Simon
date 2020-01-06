package Day12;

public class NotFullException extends Exception{
 private static final long serialVersionUID =1;
 public NotFullException() {
	super();
}
 NotFullException(String message){
	 super(message);
 }
}
