package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력하세요...");
		a = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요...");
		b = sc.nextInt();
		System.out.println("세번째 정수를 입력하세요...");
		c = sc.nextInt();
		
		int listA[] = {a, b, c};
		
		Arrays.sort(listA);
		int lastA = listA[2];
		
		System.out.println("입력값: "+a+" "+b+" "+c);
		System.out.println("최대값: "+lastA);
		System.out.println("최솟값: "+listA[0]);
		
	}
}
