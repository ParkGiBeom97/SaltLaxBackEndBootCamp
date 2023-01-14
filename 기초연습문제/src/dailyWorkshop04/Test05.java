package dailyWorkshop04;

class Account{
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	String account;
	int balance;
	double interesRate;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getInteresRate() {
		return interesRate;
	}
	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}
	
	public double calculateInterest(){
		double avg = getBalance()*(interesRate/100);
		return avg;
	}
	
	public void deposit(int money) {
		setBalance(getBalance()+money);
	}
	
	public void withdraw(int money) {
		setBalance(getBalance()-money);
	}
	public Account(String account, int balance, double interesRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interesRate = interesRate;
	}
	@Override
	public String toString() {
		return "계좌번호: "+getAccount()+" 잔액: "+getBalance() + " 이자율: " + getInteresRate();
	}
	
	
	
	
	
	
}

public class Test05 {
	
	public static void main(String[] args) {
		Account aa;
		aa = new Account("441-0290-1203", 500000, 7.3);
		
		System.out.println("계좌정보: "+aa.getAccount() + "현재잔액 : "+aa.getBalance());
		
		aa.deposit(20000);
		System.out.println("계좌정보: "+aa.getAccount() + "현재잔액 : "+aa.getBalance());
		
		System.out.println("이자: "+aa.calculateInterest());
	}

}
