package Day15;
public class Test_two {
	public static void Input1() {
		Test_one.writeIn("试试"+System.currentTimeMillis());
		System.out.println("写上去了");
		Test_one.writeIn("试完了："+System.currentTimeMillis());
	}
	public static void Input2() {
		Test_one.writeIn("我要开始写了"+System.currentTimeMillis());
		System.out.println("又写上去了");
		Test_one.writeIn("写完了："+System.currentTimeMillis());
	}
	public static void main(String[] args) {
		Input1();
		Input2();
	}
}