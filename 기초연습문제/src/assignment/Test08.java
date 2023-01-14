package assignment;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		char[] a = new char[word.length()];
		
		for(int i = a.length-1; i >= 0; i--){ 
			a[i]=(word.charAt(i));
			System.out.print(a[i]);
		}
		
		
		
		
		
	}
	
}
