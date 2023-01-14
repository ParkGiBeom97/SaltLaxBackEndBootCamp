package dailyWorkshop05;

public class Test01 {
	public static void main(String[] args) {
		String aa = args[0];
		
		char[] bb= aa.toCharArray();
		
		for(int i = (bb.length -1); i>=0; i--) {
			System.out.print(bb[i]);
		}
	}

}
