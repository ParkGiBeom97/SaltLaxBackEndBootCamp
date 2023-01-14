package assignment;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		int a;
		int b;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번쨰 정수를 입력해주세요 : ");
		a = sc.nextInt();
		System.out.println("두번쨰 정수를 입력해주세요 : ");
		b = sc.nextInt();
		
		int c = a % b;
		
		if (c > 0) {
			System.out.println("나머지가 1보다 크다!");
		} else {
			System.out.println("나머지가 1보다 같거나 작다!");
		}
		
	}
}
