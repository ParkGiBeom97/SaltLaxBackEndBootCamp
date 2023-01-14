package dailyWorkshop02;

public class Test03 {
	public static void main(String[] args) {
		
		/*
		 * for(int i=0; i<=10; i++) { for(int j=0; j<=i; j++) { System.out.print("*"); }
		 * System.out.println(); }
		 */
	
	
	//while문으로 변경
	
	int a = 0;
	while(a<=10) {
		int b = 0;
		while(b<=a) {
			if(b<=a) {
				System.out.print("*");
				b++;
			}
			
		}
		a++;
		System.out.println();
	}
}
}
