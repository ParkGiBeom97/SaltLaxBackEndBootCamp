package bank;

public class InstanceTest {

	// 1. 생성자
	public InstanceTest() {
		
	}
	
	// 2. 필드
	static int a = 100;
	int b = 200;
	
	// 3. 메소드
	public void instanceCall(String msg) {
		System.out.println(msg);
	}
	
	public static void staticCall(String msg) {
		System.out.println(msg);
	}
	
	
	public static void main(String[] args) {
		int k = 100;
		InstanceTest hong = new InstanceTest();
		
		
		hong.a = 300;
		InstanceTest.a = 500;
		hong.b = 300;
		//InstanceTest.b = 500; // 에러
	}
}
