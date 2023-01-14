package com.test;

import java.util.HashMap;
public class Company {
	
	public static void main(String[] args) {
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		map.put(1, new Secretary("aa",1,"asd",8000));
		map.put(2, new Sales("gg",2,"aasdda",700));
		
		for (Integer i: map.keySet()) {
			System.out.println(map.get(i));
		}
		
		for(Integer i : map.keySet()) {
			((Bonus)(map.get(i))).incentive(100);
		}
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i) + "   " + map.get(i).tax());
		}
		
	}
}
