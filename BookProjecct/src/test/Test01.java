package test;

import org.apache.ibatis.session.SqlSessionFactory;

import bookproject.dao.BookDAO;
import bookproject.vo.BookVO;
import mybatis.MyBatisConnectionFactory;

public class Test01 {
	public static void main(String[] args) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		BookVO book = new BookVO(); // 빈 VO생성
		book.setBisbn("89-7914-063-0");
		book.setBtitle("자바 30일 완성");
		book.setBauthor("박기범");
		book.setBprice(50000);

		int result = dao.updateByISBN(book);
		System.out.println("영향을 받은 행의 수 : " + result);

	}
}
