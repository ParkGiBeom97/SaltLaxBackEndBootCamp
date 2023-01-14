package dailyWorkshop01;

import javax.naming.spi.DirStateFactory.Result;

public class Test07 {
	public static void main(String[] args) {
		int i = 5;
		
		
		
		String result = i%2==0? "짝수" : "홀수";
		
		System.out.println("숫자 "+i+"는 " + result + "입니다.");
		}
}
