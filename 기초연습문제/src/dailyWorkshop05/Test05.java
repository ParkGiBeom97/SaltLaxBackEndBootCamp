package dailyWorkshop05;

class Mobile{
	public Mobile() {
		// TODO Auto-generated constructor stub
	}
	
	String mobileName;
	int batterySize;
	String osType;
	
	
	public int operate(int time) {
		return setBatterySize(getBatterySize() - 10*time); 
	}
	
	public int charge(int time) {
		return setBatterySize(getBatterySize() + 10*time); 
	}


	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}


	public String getMobileName() {
		return mobileName;
	}


	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}


	public int getBatterySize() {
		return batterySize;
	}


	public int setBatterySize(int batterySize) {
		return this.batterySize = batterySize;
	}


	public String getOsType() {
		return osType;
	}


	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "Mobile [" + (mobileName != null ? "mobileName=" + mobileName + ", " : "") + "batterySize=" + batterySize
				+ ", " + (osType != null ? "osType=" + osType : "") + "]";
	}
	
	
	
}

class Ltab extends Mobile{
	public Ltab() {
		// TODO Auto-generated constructor stub
	}

	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
		// TODO Auto-generated constructor stub
	}
	
}

class OTab extends Mobile{
	public OTab() {
		// TODO Auto-generated constructor stub
	}

	public OTab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
		// TODO Auto-generated constructor stub
	}
	
	public int operate(int time) {
		return setBatterySize(getBatterySize()-12*time);
	}
	
	public int charge(int time) {
		return setBatterySize(getBatterySize()+8*time);
	}
}

public class Test05 {
	
	public static void main(String[] args) {
		Ltab lt = new Ltab("Ltab", 500, "AP-01");
		OTab ot = new OTab("Otab", 1000, "AND-20");
		
		System.out.println("==========================");
		System.out.println(lt.toString());
		System.out.println(ot.toString());
		
		System.out.println("10분 충전후");
		lt.charge(10);
		ot.charge(10);
		System.out.println(lt.toString());
		System.out.println(ot.toString());
		
		System.out.println("5분 사용후");
		lt.operate(5);
		ot.operate(5);
		System.out.println(lt.toString());
		System.out.println(ot.toString());
	}
	
}












