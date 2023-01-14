package assignment;

import java.util.Scanner;

public class Test02 {
	
	public static void main(String[] args) {
		
		int a;
		int sum = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요...");
		
		a = sc.nextInt();
		
		for(int i = 1; i <=a; i++) {
			System.out.print(i+"*");
			sum *= i;
		}
		
		System.out.println("="+sum);
		
		
	}

}
