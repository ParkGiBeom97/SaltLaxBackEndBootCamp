package bank;

public class Customer {
	
	// 1. 디폴트 생성자 - 받는 인자도, 하는 일도 없는 생성자
	public Customer() {
		
	}
	
	// 2. 필드
	public String name;
	public long balance;
	
	// 3. 메소드
	public void deposit(long money) {
		int myMoney = 100;
		this.balance += money;
	}
	
//	public void withdraw(long money) {
//		this.balance -= money;
//	}
//	
}