package dailyWorkshop04;



public class Test06 {
	public static void main(String[] args) {
		
		Account aa[] = new Account[5];
		
		String ac = "221-0101-211";
		String bc = ac;
		
		for(int i =1;i<=5; i++) {
			String bb = String.valueOf(i);
			bc = ac+bb;
			System.out.println(bc);
			aa[i-1] = new Account(bc, 100000, 4.5);
			bc = ac;
			

		}
		
		for(int i=0; i <5; i++) {
			System.out.println(aa[i].toString());
		}
		
		for(int i=0; i <5; i++) {
			aa[i].setInteresRate(3.7);
		}
		System.out.println();
		System.out.println();
		
		for(int i=0; i <5; i++) {
			System.out.printf("%s 이자: %.1f",aa[i].toString(),aa[i].calculateInterest());
			System.out.println();
		}
		
	}
}
