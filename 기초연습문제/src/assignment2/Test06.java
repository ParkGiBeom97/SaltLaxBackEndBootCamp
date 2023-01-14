package assignment2;

class Plane{
	public Plane() {
		// TODO Auto-generated constructor stub
	}
	
	String planeName;
	int fuelSize;
	
	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public void reful(int fuel) {
		setFuelSize(getFuelSize()+fuel);
	}
	
	public void flight(int distance) {
		//일정 거리량 마다 운항이랑 연료 감소
	}
	
	
	
	
}

class Airplane extends Plane {
	
	String planeName;
	int fuelSize;
	
	public Airplane() {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public void flight (int distance) {
		setFuelSize(fuelSize-(distance*3));
	}
	@Override
	public String toString() {
		return planeName + "        " + fuelSize;
	}
	
	
	
}

class Cargoplane extends Plane {
	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}
	
	String planeName;
	int fuelSize;
	public Cargoplane(String planeName, int fuelSize) {
		super();
		planeName = planeName;
		this.fuelSize = fuelSize;
	}
	public String getplaneName() {
		return planeName;
	}
	public void setplaneName(String planeName) {
		planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public void flight (int distance) {
		setFuelSize(fuelSize-(distance*5));
	}
	
	@Override
	public String toString() {
		return planeName + "        " + fuelSize;
	}
	
	
}

public class Test06 {
	
	public static void main(String[] args) {
		

		Airplane air = new Airplane();
		Cargoplane car = new Cargoplane();
		
		air.planeName = "L747";
		air.fuelSize = 1000;
		
		car.planeName = "C40";
		car.fuelSize = 1000;
		
		System.out.println(air.toString());
		System.out.println(car.toString());
		System.out.println("\n==============================\n");
		//100운항
		air.flight(100);
		car.flight(100);
		System.out.println(air.toString());
		System.out.println(car.toString());
		
		System.out.println("\n==============================\n");
		air.reful(200);
		car.reful(200);
		System.out.println(air.toString());
		System.out.println(car.toString());
		
		
		
		
	}
	
}
