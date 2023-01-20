
package bank;

public class InstanceTest2 {
	
	// field
	static int a = staticCall("1번째 출력입니다.");
	int b = staticCall("2번째 출력입니다.");
	
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	
	
	// 생성자
	public InstanceTest2() {
		this.b = staticCall("3번째 출력입니다.");
		// 초기화 구문
	}
	
	public static void main(String[] args) {
		System.out.println("4번째 출력입니다.");
		int c = staticCall("5번째 출력입니다.");
		
		// 인스턴스 생성
		InstanceTest2 d = new InstanceTest2();
	}
	
	static {
		// static block
		System.out.println("a의 값은 : " + a);
	}
}
