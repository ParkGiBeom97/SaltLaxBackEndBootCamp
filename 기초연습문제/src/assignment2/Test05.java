package assignment2;

import java.util.*;

public class Test05 {

	public static void main(String[] args) {
		
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			double sum = 0.0;
			
			for(int i = 0; i <10; i++) {
				map.put(i, (int)(Math.random()*100+1));
			}
			
			Set<Integer> keySet = map.keySet(); 
			
			for(Integer m: keySet) {
				System.out.print(map.get(m)+" ");
			}
			
			for(Integer m: keySet) {
				sum += map.get(m);
			}
			
			System.out.println("\n");
			
			System.out.printf("합계 : %.2f \n", sum);
			System.out.printf("평균 : %.2f \n", sum/10);			
		
	}
	
}
