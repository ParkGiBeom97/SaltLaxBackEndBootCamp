package Sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Exam02_ObjectStream {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("1","홍길동");
		map.put("2","부처");
		map.put("3","라따뚜이");
		
		//실제파일을 생성할려면 당엲 자바쪽에서 file객체를 만들어야함
		File file = new File("readme.txt");
		
		try {
			FileOutputStream fis = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fis);
			
			oos.writeObject(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
