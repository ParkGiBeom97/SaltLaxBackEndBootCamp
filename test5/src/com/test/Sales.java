package com.test;

public class Sales extends Employee implements Bonus {

	@Override
	public void incentive(int pay) {
		setSalay((int)((pay*1.2)+getSalay()));
		
	}

	@Override
	public double tax() {
		return getSalay()*0.1;
	}

	public Sales() {
		super();
	}

	public Sales(String name, int number, String department, int salay) {
		super(name, number, department, salay);
	}
	
	
}
