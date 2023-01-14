package com.test;

public class Secretary extends Employee implements Bonus{

	@Override
	public void incentive(int pay) {
		setSalay((int)((pay*0.8)+getSalay()));
		
	}

	@Override
	public double tax() {
		return getSalay()*0.1;
	}

	public Secretary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Secretary(String name, int number, String department, int salay) {
		super(name, number, department, salay);
		// TODO Auto-generated constructor stub
	}
	
	
}
