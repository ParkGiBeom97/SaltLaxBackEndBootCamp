package dailyWorkshop05;

import java.util.ArrayList;
import java.util.Collections;

public class Test03 {
	public static void main(String[] args) {
		int[][] arr2 = {
				{20, 30, 10},
				{50, 40, 60},
				{80, 80, 90}
				};
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr.add(arr2[i][j]);
			}
		}
		for(int i =arr.size()-1; i >=0; i--) {
			System.out.print(arr.get(i) + " ");
		}

		
	}
}
