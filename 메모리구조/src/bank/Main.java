package bank;

public class Main {

	public static void main(String[] args) {
		// 여기서 프로그램 시작 (엔트리 포인트)
		Customer hong = new Customer();
		hong.name = "홍길동";
		//hong은 지역변수이자 참조변수
		
		hong.deposit(2000);
	
		
	}
}
