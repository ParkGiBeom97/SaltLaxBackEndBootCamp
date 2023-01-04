package bookproject.service;

import java.sql.Connection;
import java.sql.SQLException;

import bookproject.dao.BookDAO;
import bookproject.dao.DBCPConnectionPool;
import bookproject.view.BookMain;
import bookproject.vo.BookVO;
import bookproject.vo.RentalVO;
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





	public static ObservableList<UserVO> joinUser(String id, String pw, String em) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.userInsert(id, pw, em);
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





	public ObservableList<UserVO> UserInfo(String idID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		
		ObservableList<UserVO> list = dao.UserInfo(idID);

		return list;
	}





	public static ObservableList<RentalVO> RentalTable(String bisbn, String btitle, String idID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.rentalTb(bisbn, btitle, idID);
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		return null;
	}





	public ObservableList<RentalVO> getPersonalRentalInfo(String idID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		
		ObservableList<RentalVO> list = dao.PersnalRentalInfo(idID);

		return list;
	}





	public ObservableList<RentalVO> RentBookS() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		
		ObservableList<RentalVO> list = dao.SeeRentalBook();

		return list;
	}





	public ObservableList<BookVO> RentBookMinus(String bisbn) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		
		ObservableList<BookVO> list = dao.rentalBookCheck(bisbn);
		
		if (dao.rentalBookCheck(bisbn).get(0).getBookRental() == 0) {
			System.out.println("대출불가 보유중인 재고 없음");
		} else {
			dao.rentalMinus(bisbn);
			System.out.println("대여 성공!!" + dao.rentalBookCheck(bisbn).get(0).getBtitle()+"을 성공적으로 대여했습니다.");
		}
		

		return list;
	}



}
