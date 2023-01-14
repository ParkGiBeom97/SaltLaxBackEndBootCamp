package assignment;

import java.util.Scanner;

class Months {
	
	int months;

	public Months(int months) {
		this.months = months;
	}
	
	
	public void CalMonth() {
		if (months == 9 || months == 4 || months == 6 || months == 11 ) {
			System.out.println("마지막 일자 : 30");
		} else if (months == 1 || months == 3 || months == 5 || months == 7 || months == 8 || months == 10 || months == 11) {
			System.out.println("마지막 일자 : 31");
		} else {
			System.out.println("마지막 일자 : 28");
		}
	}
	
	
	
}

public class Test06 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
		
		if(a <= 12 && a >= 0) {
			System.out.println("입력받은 월 : "+ a);
			
			Months mon = new Months(a);
			mon.CalMonth();
			

			
		} else {
			System.out.println("입력값이 잘못됨~");
		}
		
	}

}
