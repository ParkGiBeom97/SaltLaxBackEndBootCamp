package dailyWorkshop06;

class Calc{
	public int calculate(int data) {
		int sum = 0;
		for(int i = 1; i <= data; i++) {
			if(i%2 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
}

public class Test01 {
	public static void main(String[] args) {
		Calc ca = new Calc();
		
		System.out.println("결과 : " + ca.calculate(5));
		
	}
}
