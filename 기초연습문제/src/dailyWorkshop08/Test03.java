package dailyWorkshop08;

import java.util.ArrayList;

abstract class Ship{
	public Ship() {
		// TODO Auto-generated constructor stub
	}
	
	String shipName;
	int fuelTank;
	
	public Ship(String shipName, int fuelTank) {
		super();
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}
	
	public abstract void sail(int dist);
	
	public abstract void refuel(int fuel);

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}

	@Override
	public String toString() {
		return "Ship [" + (shipName != null ? "shipName=" + shipName + ", " : "") + "fuelTank=" + fuelTank + "]";
	}
	
	
	
}

class Boat extends Ship {
	public Boat() {
		// TODO Auto-generated constructor stub
	}

	public Boat(String shipName, int fuelTank) {
		super(shipName, fuelTank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sail(int dist) {
		setFuelTank(getFuelTank()-10*dist);
		
	}

	@Override
	public void refuel(int fuel) {
		setFuelTank(getFuelTank()+ fuel*10);
		
	}
	
}

class Cruise extends Ship{
	public Cruise() {
		// TODO Auto-generated constructor stub
	}

	public Cruise(String shipName, int fuelTank) {
		super(shipName, fuelTank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sail(int dist) {
		setFuelTank(getFuelTank()-13*dist);
		
	}

	@Override
	public void refuel(int fuel) {
		setFuelTank(getFuelTank()+ fuel*8);
	}
	
	
}



public class Test03 {
	public static void main(String[] args) {
		
		ArrayList<Ship> sh = new ArrayList<Ship>();
		
		sh.add(new Boat("Boat01", 500));
		sh.add(new Cruise("Cruise01", 1000));
		
		for(int i = 0; i<sh.size(); i++) {
			System.out.println(sh.get(i));
		}
		
		for(int i = 0; i<sh.size(); i++) {
			sh.get(i).sail(10);
		}
		
		System.out.println("===========================");
		
		for(int i = 0; i<sh.size(); i++) {
			System.out.println(sh.get(i));
		}
		
		System.out.println("===========================");
		for(int i = 0; i<sh.size(); i++) {
			sh.get(i).refuel(50);
		}
		for(int i = 0; i<sh.size(); i++) {
			System.out.println(sh.get(i));
		}
		
	}
}















