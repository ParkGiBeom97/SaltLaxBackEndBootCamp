package bank;

public class OverloadingTest {
	// 1. 생성자 - 인스턴스 초기화
	public OverloadingTest() {
		// 디폴트 생성자
		// 자바의 모든 클래스가 디폴트 생성자를 가질 수 있도록 코드를 작성하는 것이 좋다
	}
	
	
	// 1-1. 생성자 overloading
	public OverloadingTest(String a, String b, int c) {
		// a, b, c = (formal) parameter (형식인자)
		this.name = a;
		this.mobile = b;
		this.age = c;
	}
	
	
	// 2. 필드
	public String name;
	public String mobile;
	public int age;
	
	// 3. 메소드
	public static void main(String[] args) {
		OverloadingTest tmp = new OverloadingTest();
		// 인스턴스가 만들어지면, 인스턴스 안에 name, mobile, age의 공간 생성됨
		// 초기값은? 없음 -> 데이터값의 초기값으로 설정됨
		// name = empty String (아무 값도 없는 문자열), ""
		// age = 0
		
		tmp.name = "홍길동";
		tmp.mobile = "010-1111-2222";
		tmp.age = 20;
		
		OverloadingTest tmp2 = new OverloadingTest("홍길동", "010-2222-3333", 22);
		// "홍길동", "010-2222-3333", 22 = argument (실인자) = actual parameter
		
	}
	
	
}
