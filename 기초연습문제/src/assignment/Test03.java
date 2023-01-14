package assignment;

public class Test03 {
	
	public static void main(String[] args) {
		int inx = 0;
		
		for(int i = 0; i <= 6; i++) {
			int jnx = 0;
			for(jnx = 0; jnx<=inx; jnx++) {
				System.out.print("*");
				jnx++;
			}
			System.out.print("@");
			inx++;
		}
}
	
}
