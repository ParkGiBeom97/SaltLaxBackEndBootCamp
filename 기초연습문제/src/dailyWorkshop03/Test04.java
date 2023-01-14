package dailyWorkshop03;

public class Test04 {
	
	public static void main(String[] args) {
		
		int[] arr3 = new int[5];
		
		
		for(int i = 0; i < arr3.length ; i++){

			arr3[i] = (int)(Math.random() * 9) + 1;
			

		    for(int j = 0; j < i; j ++){
		        if(arr3[i] == arr3[j]){
		            i--; 
		            break; 
		        }
		    }
		}
		
		for(int i=0;i<arr3.length;i++) {
			System.out.print(arr3[i]+"  ");
		}
		System.out.println("\n");
		
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		for(int i = 0; i <arr3.length; i++) {
				sum += arr3[i];
				cnt++;
		
		}
		System.out.println("total : " + sum);
		avg = sum / (double)cnt;
		System.out.println("average : "+avg);
		

				
				
		
	}
	

}
