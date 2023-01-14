package assignment2;

import java.util.HashMap;


abstract class Employee{
	String name;
	int number;
	String department;
	int salay;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int number, String department, int salay) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salay = salay;
	}
	
	public abstract Double tax();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalay() {
		return salay;
	}

	public void setSalay(int salay) {
		this.salay = salay;
	}

	@Override
	public String toString() {
		return name + "  " + department+"   "+ salay;
	}
	
	
	
}

interface Bonus {
	public void incentive(int pay);
}

class Secretary extends Employee implements Bonus{
	
	public Secretary() {
		super();
	}	

	public Secretary(String name, int number, String department, int salay) {
		super(name, number, department, salay);
	}
	


	@Override
	public void incentive(int pay) {
		setSalay((int)((pay*1.2)+getSalay())); 	
	}

	@Override
	public Double tax() {
		return getSalay()*0.1;
	}
}

class Sales extends Employee implements Bonus{

	@Override
	public void incentive(int pay) {
		setSalay((int)((pay*0.8)+getSalay()));
	}
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(String name, int number, String department, int salay) {
		super(name, number, department, salay);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Double tax() {
		return getSalay()*0.1;
	}
	
}

public class Test07 {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		map.put(1, new Secretary("Hiery", 1, "Secretary", 800));
		map.put(2, new Sales("Clinten", 2, "Sales", 1300));
		
		for (Integer i: map.keySet()) {
			System.out.println(map.get(i));
		}
		
		for (Integer i: map.keySet()) {
			((Bonus)(map.get(i))).incentive(100);
		}
		
		for (Integer i: map.keySet()) {
			System.out.println(map.get(i));
		}
		
	}
		
}
