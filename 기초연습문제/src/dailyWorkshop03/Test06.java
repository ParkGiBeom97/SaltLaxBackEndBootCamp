package dailyWorkshop03;

class Student{
	String name;
	int korean;
	int english;
	int math;
	int science;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int korean, int english, int math, int science) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.science = science;
	}
	
	public double getAvg() {
		double avg = (korean+english+math+science)/4;
		return avg;
	}
	
	public String getGrade() {
		
		String bb = "";
		if( 100>= getAvg() && getAvg() >=90) {
			bb = "A";
		} else if ( 90> getAvg() && getAvg() >=70) {
			bb = "B";
		}else if ( 70> getAvg() && getAvg() >=50) {
			bb = "C";
		}else if ( 50> getAvg() && getAvg() >=30) {
			bb = "D";
		}else {
			bb = "F";
		}
		
		return bb;
	}
}

public class Test06 {
	
	public static void main(String[] args) {
		Student kim = new Student("Kim", 100, 90, 95, 89);
		Student lee = new Student("Lee", 60, 70, 99, 98);
		Student park = new Student("Park", 68, 86, 60, 40);
		
		System.out.println(kim.name + " 평균 : "+ kim.getAvg()+" 학점 : "+kim.getGrade()+" 학점");
		System.out.println(lee.name + " 평균 : "+ lee.getAvg()+" 학점 : "+lee.getGrade()+" 학점");
		System.out.println(park.name + " 평균 : "+ park.getAvg()+" 학점 : "+park.getGrade()+" 학점");
		
	}

}
