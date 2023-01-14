package assignment1;

public class Test03 {

	public static void main(String[] args) {
		for(int i = 3; i<= 5; i++) {
			for(int j =1; j<=9; j++) {
				int mu = i*j;
				if (mu %2 == 1) {
						System.out.println(i+"*"+j+"="+i*j);

				}
			}
		}
	}
	
}
