package dailyWorkshop05;

class Student{
	String name;
	int age;
	int height;
	int weight;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Student [" + (name != null ? "name=" + name + ", " : "") + "age=" + age + ", height=" + height
				+ ", weight=" + weight + "]";
	}
	
	
	
	
}

public class Test04 {
	
	public static void main(String[] args) {
		Student studentArray [] = new Student[3];
		
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임꺽정", 16, 175, 65);
		
		for(int i=0; i<studentArray.length; i++) {
			System.out.println(studentArray[i].toString());
		}
		
		double sum = 0.00;
		for(int i=0; i<studentArray.length; i++) {
			sum += studentArray[i].age;
		}
		double ageAvg = sum/studentArray.length;
		System.out.printf("평균 나이 :  %.2f",ageAvg);
		
		sum = 0.00;
		for(int i=0; i<studentArray.length; i++) {
			sum += studentArray[i].height;
		}
		double heightAvg = sum/studentArray.length;
		System.out.printf("\n평균 나이 :  %.2f",heightAvg);
	}

}
