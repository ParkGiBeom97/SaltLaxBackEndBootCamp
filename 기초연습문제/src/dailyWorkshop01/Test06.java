package dailyWorkshop01;

public class Test06 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a+b);
		char ch = 'A';
		ch = (char)((int)ch + 2);
		float f = (float)1.5;
		long l = 27000000000L;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = true; //(boolean)((float)d) ;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
		}
}
