package dailyWorkshop02;

public class Test07 {

	public static void main(String[] args) {
		
		String str = args[0];
		
		int num = Integer.parseInt(str);
		
		int sum = 0;
		
		for(int i = 1; i<=100; i++) {
			if (i % num == 0 ) {
				sum += i;
			}
		}
		
		System.out.println(num + "의 배수의 합 => "+sum);
		
	}
	
}
