package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {
	private SqlSessionFactory factory;
	
	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public HashMap<String, Object> selectByISBNHashMap(String isbn) {
		
		
		HashMap<String, Object> map = null;
		
		SqlSession session = factory.openSession();
		
		
		//map = session.selectOne("어떤거 실행해야하나요?", 넘겨줄 인자값);
		
		try {
			map = session.selectOne("example.myBook.selectBookByISBNHashMap", isbn);
		} catch (Exception e) {
			
		} finally {
			session.close();
		}

		
		
		return map;
	}

	public List<HashMap<String, Object>> selectAllHashMap() {
		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("example.myBook.selectAllHashMap"); //selectList는 모든 정보를 리스트로 만들어서 반환해줌
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return list;
	}

	public BookVO selectByISBNBookVO(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		
		
		try {
			book = session.selectOne("example.myBook.selectBookByISBNBookVO", isbn);
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return book;
	}

	public BookVO selectByISBNResultMap(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		
		
		try {
			book = session.selectOne("example.myBook.selectBookByISBNResultMap", isbn);
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return book;
	}

	public int updateByISBN(BookVO book) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		//업데이트 구문은 update를 사용한다
		try {
			result = session.update("example.myBook.update", book);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		
		return result;
	}
}












