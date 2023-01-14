package dailyWorkshop05;

import java.net.MulticastSocket;

class Company{
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getIncome() {
		return getSalary()*12;
	}
	
	public double getAfterTaxIncome(){
		return getIncome() - (getIncome() * 0.1);
	}
	
	public double getBonuce() {
		return (getSalary()*0.2)*4;
	}
	
	public double getAfterTaxBonus() {
		return getBonuce() - (getBonuce()*0.055);
	}
	
}

public class Test02 {
	
	public static void main(String[] args) {
		String aa = args[0];
		int bb = Integer.parseInt(aa);
		
		Company cp = new Company();
		cp.setSalary(bb);
		
		System.out.println("연 기본급 합 : " + cp.getIncome()+ " 세후 : "+cp.getAfterTaxIncome());
		System.out.println("연 보너스 합 : " + cp.getBonuce()+ " 세후 : "+cp.getAfterTaxBonus());
		System.out.println("연 지급액 합 : " + (cp.getAfterTaxIncome()+cp.getAfterTaxBonus()));
	}

}






