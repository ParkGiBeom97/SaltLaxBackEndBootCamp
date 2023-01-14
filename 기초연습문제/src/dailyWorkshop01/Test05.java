package dailyWorkshop01;

public class Test05 {

	public static void main(String[] args) {
		int fahrenheit = 100;

		
		//공식: C = 5/9 * (F-32)
		float a = (float)5/(float)9;
		
		float celcius = (float)(a * (fahrenheit-32));
		
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
		}
	
}
