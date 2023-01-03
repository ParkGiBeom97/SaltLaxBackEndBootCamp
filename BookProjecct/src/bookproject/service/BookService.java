package bookproject.service;

import java.sql.Connection;
import java.sql.SQLException;

import bookproject.dao.BookDAO;
import bookproject.dao.DBCPConnectionPool;
import bookproject.view.BookMain;
import bookproject.vo.BookVO;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;

public class BookService {

	public ObservableList<BookVO> BookSerch(String text) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		
		ObservableList<BookVO> list = dao.BookSerch(text);

		return list;
	}





	public static ObservableList<UserVO> joinUser(String id, String pw) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.userInsert(id, pw);
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		return null;
	}






	public static Boolean loginUser(String text, String text2) {
		
		Connection con = null;
		BookDAO dao = null;
		Boolean loginResult = false;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			dao = new BookDAO(con);
			dao.userLogin(text, text2);
			
			if( text.equals(dao.userLogin(text, text2).getUser_ID()) && text2.equals(dao.userLogin(text, text2).getUser_PW())){
				loginResult = true;			
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return loginResult;
	}

}
