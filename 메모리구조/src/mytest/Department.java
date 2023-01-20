package mytest;

public class Department {	// 학과 클래스
	
	public Department() {
	}
	public Department(String depName, String depNumber) {
		this.depName = depName;
		this.depNumber = depNumber;
	}
	
	// field
	private String depName;		// 학과명
	private String depNumber;	// 학과 전화번호
	public String getDepName() {
		return depName;
	}
	
	// method
	// 비즈니스 메소드는 패스
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepNumber() {
		return depNumber;
	}
	public void setDepNumber(String depNumber) {
		this.depNumber = depNumber;
	}
	
}
