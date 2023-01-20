package bpackage;


class BClass {
	// 1. constructor
	BClass() {
			
	}
		
	// 2. field
	private int bField;
	// 클래스 내에서만 조회와 변경이 가능한 private -> 특수한 목적의 메소드 이용
	// -> getter & setter -> public으로 잡아야 다른 클래스에서도 사용 가능
	
	
	
	// 3. method
	void bMethod() {
		System.out.println("안녕하세요!");
	}

	// getter
	public int getbField() {
		return bField;
	}
	
	// setter
	public void setbField(int bField) {
		this.bField = bField;
	}
	
}
