package Day16;

public  class Person implements Comparable<Person>{
String name;
int age;
Person(String name,int age){
	this.name=name;
	this.age=age;
}
public String getName() {
	
	return name;
}
public void setName(String name) {
	this.name=name;
	
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age=age;
}
@Override
public int compareTo(Person o) {
	if(this.age>o.getAge()) return 1;
	if(this.age<o.getAge()) return -1;
	return 0;
}
}
