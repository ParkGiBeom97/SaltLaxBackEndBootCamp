package assignment1;

public class Test06 {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		
		int len = array.length;
		double sum = 0;
		
		for(int i = 0; i<len; i++) {
			if(array[i] % 2 == 1) {
				System.out.println(array[i]);
				sum += array[i];
			}
		}
		
		System.out.println("합계 : " + sum);
	}
	
}
