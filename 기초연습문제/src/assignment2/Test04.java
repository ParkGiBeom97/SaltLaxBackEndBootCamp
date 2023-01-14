package assignment2;

import java.util.*;

public class Test04 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i =0; i <10; i++) {
			list.add((int)(Math.random()*10+1));
		}
		for(int i =0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
		System.out.println("\n");
		

		Collections.sort(list);
		
		for(int i =0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
	
}
