package dailyWorkshop04;

public class Test03 {
	public static void main(String[] args) {
		String a = args[0];
		String b = args[1];
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		
		if(args.length <2 || args.length >2) {
			System.out.println("다시 입력하세요.");
		}
		
		int[][] arr = new int[aa][bb];
		
		for(int i = 0; i <aa; i++) {
			for(int j = 0; j <bb; j++ ) {
				arr[i][j]=(int)(Math.random()*5)+1;
			}
		}
		
		double sum = 0;
		
		for(int i = 0; i <aa; i++) {
			for(int j = 0; j <bb; j++ ) {
				sum += arr[i][j];
			}
		}
		
		double avg;
		
		avg = sum/(aa*bb);
		
		System.out.println("sum = "+sum);
		System.out.println("avg : " + avg);
		
		
	}
}
