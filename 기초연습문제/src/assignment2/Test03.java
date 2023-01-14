package assignment2;

import java.util.*;

public class Test03 {
	public static void main(String[] args) {
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data []= new double[5]; 
		double sum = 0.0;
		double avg = 0.0;
		
		String []tokens=str.split(",");
		
		for(int i=0;i<tokens.length;i++){
			data[i] = Double.parseDouble(tokens[i]);
		}
		
		for(int i = 0; i<data.length; i++) {
			sum += data[i];
		}
		
		System.out.println("합계 : " + sum);
		avg = sum/5;
		System.out.println("평균 : " + avg);
		
		
		
	}
}
