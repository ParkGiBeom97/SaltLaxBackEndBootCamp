package example.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {
	public static void main(String[] args) {
		//간단하게 책을 조회하고 삭제하는 데이터베이스 처리를 할 예정
		//mybatis로 할 예정임
		//실습이므로 굳이 MVC로 안함
		
		
		//1. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요
		//DAO부터 생성해서 처리하면 될 것 같습니다.
		//기존에는 dao한테 커넥션을 넘겨주었음
		//이번에는 dao에게 SqlSessionFactory를 줍니다.
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory);
		
//		HashMap<String, Object> map = dao.selectByISBNHashMap("89-7914-063-0");
//		for(String key: map.keySet()) {
//			System.out.println(key + ", "+map.get(key));
//		}
		
		//2. 조건 없이 모든 책의 데이터를 가져와서 출력하세요
		//기존에는 dao한테 커넥션을 넘겨주었음
		//이번에는 dao에게 SqlSessionFactory를 줍니다.
		
//		List<HashMap<String, Object>> list = dao.selectAllHashMap();
//		for(HashMap<String, Object> map : list) {
//			for(String key: map.keySet()) {
//				System.out.println(key + ", " + map.get(key));
//			}
//		}
		
		//3. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요
		//이번에는 HashMap이 아니라 VO를 이용할 예정입니다
//		BookVO book = dao.selectByISBNBookVO("89-7914-063-0");
//		System.out.println(book.getBtitle() + "  , " + book.getBauthor());
		
		
		//4. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요
		//3번문제와는 약간 다르게 해서 출력
//		BookVO book = dao.selectByISBNResultMap("89-7914-063-0");
//		System.out.println(book.getBtitle() + "  , " + book.getBauthor());
		
		
		//5. 책의 ISBN을 이용해서 책 1권의 데이터를 업데이트하기
		//업데이트를 하게 되면 결과가 정수형(integer)로 출력됨
		BookVO book = new BookVO(); //빈 VO생성
		book.setBisbn("89-7914-063-0");
		book.setBtitle("자바 30일 완성");
		book.setBauthor("박기범");
		book.setBprice(50000);
		
		int result = dao.updateByISBN(book);
		System.out.println("영향을 받은 행의 수 : " + result);
		
		
	}
}














