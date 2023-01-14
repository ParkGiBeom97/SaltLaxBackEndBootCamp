package assignment;

import java.util.Scanner;

public class Test07 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, d, e;
		
		System.out.println("정수 5개를 입력");
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		
		int sum = (int)((((a+b)/2)*0.6)+(((c+d)/2)*0.2)+(e*0.8));
		
		if (sum>=90) {
			System.out.println("Gold Class");
		} else if (sum >=80) {
			System.out.println("Silver Class");
		} else if (sum >= 70) {
			System.out.println("Bronze Class");
		} else {
			System.out.println("Nomal Class");
		}
		
	}
	
}
