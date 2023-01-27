package jdbc.vo;

public class Test {
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	private String department_name;
	private String category;
	private int capacity;
	
	
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	public Test(String department_name, String category, int capacity) {
		super();
		this.department_name = department_name;
		this.category = category;
		this.capacity = capacity;
	}
	
	
	@Override
	public String toString() {
		return "Test [" + (department_name != null ? "department_name=" + department_name + ", " : "")
				+ (category != null ? "category=" + category + ", " : "") + "capacity=" + capacity + "]";
	}
	
	

	
}
