package SampleProJ;


//공용객체
class Account {
	//생성자
	public Account() {
		
	}
	
	//필드
	private int balance;
	
	//출금이라는 비지니스 메소드 작성
	public void withdraw(int money) {
		
		synchronized (this) { 
			
		
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			balance -= money;
		}
		
		}
		
		
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}

class ThreadEx_12_1 implements Runnable {
	
	//field
	Account acc = new Account(1000);
	
	
	@Override
	public void run() {
		
		while(acc.getBalance() > 0 ) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money); //공용 객체에 출금 처리
			System.out.println("남은 금액 : " + acc.getBalance());
			System.out.println(Thread.currentThread().getName());
			

		}
		
	}
}



public class ThreadEx12 {
	public static void main(String[] args) {
		
		ThreadEx_12_1 r = new ThreadEx_12_1();
		Thread t1 = new Thread(r,"*");
		Thread t2 = new Thread(r,"**");
		
		t1.start();
		t2.start();
		
		
		
		
	}
}









