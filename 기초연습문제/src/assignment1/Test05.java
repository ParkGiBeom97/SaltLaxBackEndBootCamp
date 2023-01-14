package assignment1;

import java.util.Scanner;

class calc{
	
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public int divide(int a, int b) {
		if (b <= 0) {
			return 0;
		}
		return a / b;
	}
	
}

public class Test05 {

	public static void main(String[] args) {
		
		
		calc aa = new calc();
		
		String strN1 = args[0];
		String strN2 = args[1];
		
		int a = Integer.parseInt(strN1);
		int b = Integer.parseInt(strN2);
		
		System.out.println("합 : " + aa.sum(a, b));
		System.out.println("차: " + aa.subtract(a, b));
		System.out.println("곱하기 : " + aa.multiply(a, b));
		System.out.println("나누기 : " + aa.divide(a, b));
		
	}
	
	
}
