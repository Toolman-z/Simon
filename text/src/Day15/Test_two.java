package Day15;
public class Test_two {
	public static void Input1() {
		Test_one.writeIn("����"+System.currentTimeMillis());
		System.out.println("д��ȥ��");
		Test_one.writeIn("�����ˣ�"+System.currentTimeMillis());
	}
	public static void Input2() {
		Test_one.writeIn("��Ҫ��ʼд��"+System.currentTimeMillis());
		System.out.println("��д��ȥ��");
		Test_one.writeIn("д���ˣ�"+System.currentTimeMillis());
	}
	public static void main(String[] args) {
		Input1();
		Input2();
	}
}