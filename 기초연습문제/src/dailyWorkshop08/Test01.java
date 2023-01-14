package dailyWorkshop08;

import java.util.HashSet;
import java.util.Iterator;

public class Test01 {
	public static void main(String[] args) {
		String a = args[0];
		
		String[] arr = a.split("");
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		
		HashSet<String> aa = new HashSet<String>();
		
		
		
		for(int i = 0; i < a.length(); i++) {
			aa.add(arr[i]);	
		}
		
		System.out.println();
		
//		Iterator iter = aa.iterator();	// Iterator 사용
//		while(iter.hasNext()) {//값이 있으면 true 없으면 false
//		    System.out.print(iter.next());
//		}

		System.out.println(aa);
		
	}
}
