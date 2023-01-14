package dailyWorkshop05;

public class Test06 {
	public static void main(String[] args) {
		
		String str = "JAVAProgramming";
		
		str = str.toLowerCase();
		System.out.println(str);
		
		str = str.toUpperCase();
		System.out.println(str);
		
		System.out.println(str.substring(0, 4));
		System.out.println(str.substring(4, str.length()));
	}
}
