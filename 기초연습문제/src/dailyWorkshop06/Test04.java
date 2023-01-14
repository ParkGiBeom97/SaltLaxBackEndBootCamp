package dailyWorkshop06;

abstract class Car{
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	String name;
	String engin;
	int oilTank;
	int oilSize;
	int distance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEngin() {
		return engin;
	}
	public void setEngin(String engin) {
		this.engin = engin;
	}
	public int getOilTank() {
		return oilTank;
	}
	public void setOilTank(int oilTank) {
		this.oilTank = oilTank;
	}
	public int getOilSize() {
		return oilSize;
	}
	public void setOilSize(int oilSize) {
		this.oilSize = oilSize;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Car(String name, String engin, int oilTank, int oilSize, int distance) {
		super();
		this.name = name;
		this.engin = engin;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Car [" + (name != null ? "name=" + name + ", " : "") + (engin != null ? "enginsize=" + engin + ", " : "")
				+ "oilTank=" + oilTank + ", oilSize=" + oilSize + ", distance=" + distance + "]";
	}
	
	
	public abstract void go(int distance);
	public abstract void setOil(int oilSize);
}

interface Temp{
	public int getTempGage();
}

class L3 extends Car implements Temp {

	public L3() {
		super();
	}

	public L3(String name, String engin, int oilTank, int oilSize, int distance) {
		super(name, engin, oilTank, oilSize, distance);
	}

	@Override
	public int getTempGage() {
		return getDistance()/10;
	}

	@Override
	public void go(int distance) {
		setOilSize(getOilSize()-(getDistance()/10));
		
	}

	@Override
	public void setOil(int oilSize) {
		setOilSize(getOilSize()+oilSize);
	}
	
}

class L5 extends Car implements Temp{

	public L5() {
		super();

	}

	public L5(String name, String engin, int oilTank, int oilSize, int distance) {
		super(name, engin, oilTank, oilSize, distance);

	}

	@Override
	public int getTempGage() {
		return (getDistance()/10)*2;
	}

	@Override
	public void go(int distance) {
		setOilSize(getOilSize()-(getDistance()/8));
		
	}

	@Override
	public void setOil(int oilSize) {
		setOilSize(getOilSize()+oilSize);
	}
	
	
	
}



public class Test04 {
	
	public static void main(String[] args) {
		Car[] carr = new Car[2];
		
		carr[0] = new L3("L3", "1500", 50, 25, 0);
		carr[1] = new L5("L5", "2000", 70, 35, 0);
		
		for(int i = 0; i<carr.length; i++) {
			System.out.println(carr[i]+"    온도 => "+((Temp)(carr[i])).getTempGage());
		}
		
		//각 자동차에 25 주유
		for(int i = 0; i<carr.length; i++) {
			carr[i].setOil(25);
		}
		
		System.out.println("====주유한 자동차의 정보 출력 =====");
		for(int i = 0; i<carr.length; i++) {
			System.out.println(carr[i]+"    온도 => "+((Temp)(carr[i])).getTempGage());
		}
		
		//80주행하기
		for(int i = 0; i<carr.length; i++) {
			carr[i].setDistance(80);
			carr[i].go(80);
		}
		
		System.out.println("====주행한 자동차의 정보 출력 =====");
		for(int i = 0; i<carr.length; i++) {
			System.out.println(carr[i]+"    온도 => "+ ((Temp)(carr[i])).getTempGage());
		}
		
	}

}
