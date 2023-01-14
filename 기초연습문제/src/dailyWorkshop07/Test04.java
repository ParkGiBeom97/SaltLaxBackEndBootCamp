package dailyWorkshop07;

public class Test04 {
	public static void main(String[] args) {
		
		String str = "4,2,3,6,7";
		
		String[] arr = str.split(",");
		
		int sum = 0;
		
		for(int i =0; i <arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
		
		
	}
}
