package dailyWorkshop01;

public class Test03 {
	
	public static void main(String[] args) {
		
		int num = 485;
		int a = (int)(Math.log10(num)+1); //4자리 수인건 구함
		int b = 1;
		
		for(int i = 0; i < a-1; i++) {
			b = b * 10;
		}

		int c = num / b; //가장 큰 자릿수도 구함
		
		for(int i = 0; i < a-1; i++) {
			c = c * 10;
		}
		
		

		System.out.println(c);
		}
		
}


