package dailyWorkshop04;

class Calc{
	public void calculate(int a) {
		int sum = 0;
		System.out.print("짝수 :");
		for(int i =1; i <=a; i++) {
			if(i%2 == 0) {
				sum+= i;
				System.out.print(" "+i);
			}
		}
		System.out.println();
		System.out.println("결과: "+sum);
		
	}
}

public class Test04 {
	public static void main(String[] args) {
		String a = args[0];
		int aa = Integer.parseInt(a);
		
		Calc cal = new Calc();
		
		cal.calculate(aa);
		
	}
}
