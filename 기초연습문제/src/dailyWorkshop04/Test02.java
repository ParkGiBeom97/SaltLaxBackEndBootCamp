package dailyWorkshop04;

import java.util.ArrayList;

public class Test02 {

	public static void main(String[] args) {
		String args1 = args[0];
		int numA = Integer.parseInt(args1);
		int sumA = 0;
		ArrayList<Integer> numL = new ArrayList<Integer>();
				
		for(int i = numA; i<=10; i++) {
			if(i%3 == 0) {
				
			} else if(i%5 == 0) {
				
			} else {
				sumA += i;
				numL.add(i);
			}

		}
		for(int i = 0; i<numL.size(); i++) {
			System.out.print(numL.get(i));
			if(i<numL.size()-1) {
				System.out.print("+");
			}
		}
		System.out.println();
		System.out.println("결과: "+sumA);
		
	}
	
}
