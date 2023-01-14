package dailyWorkshop03;

public class Test05 {
	
	
	public static int sumM(int[] arr1) {
		int sum = 0;
		int[] arr = arr1;
		
		for(int i =0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[args.length];
		
		for(int i =0; i< args.length; i++) {
			String a = args[i];
			arr[i] = Integer.parseInt(a);
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		

		double avg = 0.0;
		
		int aa = sumM(arr);
		
		avg = (double)aa/args.length;
		
		System.out.println("sum : " + aa);
		
		System.out.println("Avg : " + avg);
		
		String bb;
		
		if( 100>= avg && avg >=90) {
			bb = "A";
		} else if ( 90> avg && avg >=70) {
			bb = "B";
		}else if ( 70> avg && avg >=50) {
			bb = "C";
		}else if ( 50> avg && avg >=30) {
			bb = "D";
		}else {
			bb = "F";
		}
		
		System.out.println(bb+" 학점");
		

	}

}
