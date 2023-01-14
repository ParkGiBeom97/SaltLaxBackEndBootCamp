package dailyWorkshop08;

import java.util.ArrayList;

class MakeList{
	
	ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public MakeList() {
		// TODO Auto-generated constructor stub
	}
	
	public void makeArray(int size) {
		for(int i = 0; i<size; i++) {
			arr.add((int)((Math.random()*100)+1));
		}
	}
	
	public ArrayList<Integer> getList(){
		return arr;
	}
}

public class Test02 {
	
	public static void main(String[] args) {
		ArrayList<Integer> bb = new ArrayList<Integer>();
		
		MakeList arr = new MakeList();
		
		String a = args[0];
		int aa = Integer.parseInt(a);
		
		arr.makeArray(aa);
		System.out.println(arr.getList());
		
		for(int i = 0; i<arr.getList().size(); i++) {
			bb.add(arr.getList().get(i));
		}
		

		int sum = 0;
		
		for(int i = 0; i<bb.size(); i++) {
			sum += bb.get(i);
		}
		
		double avg = (double)sum/bb.size();
		
		System.out.printf("평균 : %.1f",avg);
			
	}

}
