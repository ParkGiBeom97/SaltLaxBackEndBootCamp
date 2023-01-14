package com.test;

public abstract class Employee {
	public Employee() {
		
	}
	
	private String name;
	private int number;
	private String department;
	private int salay;
	
	public Employee(String name, int number, String department, int salay) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salay = salay;
	}

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
	
	public abstract double tax();

	@Override
	public String toString() {
		return name+"   "+department+"   "+salay;
	}
	
	
	
	
	
}
