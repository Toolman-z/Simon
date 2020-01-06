package Day21;

public class Dog {
private static Dog dog;
private  Dog() {	
}	
public synchronized static Dog getInstance() {
if(dog==null) {
	dog=new Dog();
}
	return dog;
}	
}
