package Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01_KeyboardInput {
	
	public static void main(String[] args) {
		
		System.out.println("키보드로 한줄을 입력하세요!");
		
		//키보드로부터 입력을 받으려면 데이터 연결통로 즉 Stream이 있어야함
		//system.in은 그냥 InputStream이라 사용하기 너무 불편함.
		//System.in
		
		//문자 기반의 데이터를 받아야하니 Reader를 하나 만들어줍니다.
		//이런식으로 스트림을 결합하여 조금 더 편한 문자 기반의 통로를 열 수 있습니다.
		//new InputStreamReader(System.in);
		//이것도 근데 불편한 사용이기 때문에 아래와 같이 사용해줍니다.
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			String s = br.readLine();
			System.out.println("입력받은 데이터는 : " + s);
		} catch (IOException e) {
			
		}
		
		
		
		
		
		
	}

}
