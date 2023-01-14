package assignment1;

public class Test04 {

	public static void main(String[] args) {
		
		double sum = 0;
		double mu;
		
		int i = 1;
		while(i<=100) {
			sum += i;
			i++;
		}
		
		mu = sum /100;
		
		System.out.println(sum+"\n"+mu);
		
	}
	
}
