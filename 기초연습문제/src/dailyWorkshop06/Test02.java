package dailyWorkshop06;

class Calculator{
	
	public double plus(int a, int b) {
		return a+b;
	}
	
	public double minus(int a, int b) {
		return a-b;
	}
	
	public double multiplication(int a, int b) {
		return a*b;
	}
	
	public double divide(int a, int b) {
			try {
				return a/b;
			} catch (Exception e) {
				System.out.println("분모에는 0이 올 수 없습니다.");
				return 0.0;
			}
	}
}

public class Test02 {
	public static void main(String[] args) {
		
		Calculator cl = new Calculator();
		
		String a = args[0];
		String b = args[1];
		String c = args[2];
		
		int aa = Integer.parseInt(a);
		int cc = Integer.parseInt(c);
		
		
		if(b.equals("+")) {
			System.out.println("결과 : " + cl.plus(aa, cc));
		} else if (b.equals("/")) {
			System.out.println("결과 : " + cl.divide(aa, cc));
		} else if (b.equals("*")) {
			System.out.println("결과 : " + cl.multiplication(aa, cc));
		} else if (b.equals("-")) {
			System.out.println("결과 : "+ cl.minus(aa, cc));
		}
		
	}
}
