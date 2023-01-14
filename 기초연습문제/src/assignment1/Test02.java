package assignment1;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int mu = a*b;
		
		int len = (int)(Math.log10(mu)+1);
		
		System.out.println(len+"자리 수 입니다.");
		
	}
}
