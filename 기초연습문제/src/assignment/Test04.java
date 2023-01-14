package assignment;

public class Test04 {
	public static void main(String[] args) {
		

		int sum = 0;
		
		for(int i = 1; i<=6; i++) {
			for(int j = 1; j<=6; j++) {
				for(int k =1; k<=6; k++) {
					sum = i * j * k;
					if(sum % 3 == 0) {
						System.out.println(sum);
					}
				}
			}
		}
		
		
	}
}
