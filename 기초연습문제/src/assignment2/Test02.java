package assignment2;


class Human{
	String name;
	int age;
	int height;
	int weight;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	public String printInformation() {
		return "";
	}
}

class Student{
	String name;
	int age;
	int height;
	int weight;
	String number;
	String major;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int height, int weight, String number, String major) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.number = number;
		this.major = major;
	}
	
	public String printInformation() {
		return name+"  "+age+"  "+height+"  "+weight+"  "+number+"  "+major;
	}
	
	
}

public class Test02 {

	public static void main(String[] args) {
		Student studentArray[] = new Student[3];
		
		studentArray[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		studentArray[1] = new Student("한사람", 13, 183, 72, "201102", "건축");
		studentArray[2] = new Student("임걱정", 16, 175, 65, "201103", "무영");
		
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i].printInformation());
		}
		
		
		
	}
		
}
