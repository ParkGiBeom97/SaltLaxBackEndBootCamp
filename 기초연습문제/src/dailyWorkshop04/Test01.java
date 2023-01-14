package dailyWorkshop04;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		 Arrays.sort(arr);
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
