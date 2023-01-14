package dailyWorkshop07;

public class Test02 {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("JAVAprogramer");
		

		String str = sb.substring(0,1).toUpperCase()+sb.substring(1,4).toLowerCase()+sb.substring(4,5).toUpperCase()+sb.substring(5);
		
		System.out.println(str);
		
		
	}

}
