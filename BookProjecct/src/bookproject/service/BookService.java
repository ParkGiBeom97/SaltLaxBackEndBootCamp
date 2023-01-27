package bookproject.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bookproject.dao.BookDAO;
import bookproject.dao.DBCPConnectionPool;
import bookproject.view.BookMain;
import bookproject.vo.BookVO;
import bookproject.vo.LogVO;
import bookproject.vo.RentalVO;
import bookproject.vo.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import mybatis.MyBatisConnectionFactory;

public class BookService {
	
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	BookDAO dao = new BookDAO(factory);

	
	public BookService() {
		// TODO Auto-generated constructor stub
	}
	
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
	
	
	//도서 검색 마이바티스로 하는 서비스모델 코드
	public ObservableList<BookVO> BookSerchM(String text) {
		BookDAO dao = new BookDAO(factory);
		ObservableList<BookVO> list = dao.selectAllBook(text);
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





	public RentalVO returnBookService(String bisbn, String idID, Date date) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.returnBook(bisbn, idID, date);
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		return null;
	}





	public BookVO plusBookService(String bisbn) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.plusBook(bisbn);
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		return null;
	}





	public ObservableList<BookVO> deletBService(String bisbn, String searchKeyword) {
		
		Connection con = null;
		ObservableList<BookVO> list = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.deleteBBook(bisbn);
			list = dao.BookSerch(searchKeyword);
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		
		return list;
	}





	public RentalVO deletRService(String bisbn) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			int count = dao.deleteRBook(bisbn);
			
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		return null;
	}





	public ObservableList<BookVO> addBookService(String text, String text2, String text3, int parseInt, int parseInt2,
			String text4, String text5, String text6, String text7, int parseInt3) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			int count = dao.addBook(text, text2, text3, parseInt, parseInt2,
					text4, text5, text6, text7, parseInt3);
			System.out.println(count);
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
		}
		return null;
	}





	public ObservableList<BookVO> updateBookService(String text, String text2, String text3, int parseInt,
			int parseInt2, String text4, String text5, String text6, String text7, int parseInt3, String bookISBN) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			int count = dao.updateBook(text, text2, text3, parseInt, parseInt2,
					text4, text5, text6, text7, parseInt3, bookISBN);		
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			
		}
		return null;
	}





	public UserVO setUserDateService(String string, String string2, String string3, String idID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			int count = dao.userUpdate(string, string2, string3, idID);		
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			
		}
		return null;
	}





	public ObservableList<LogVO> getLogService() {
		
		Connection con = null;
		ObservableList<LogVO> list = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			list = dao.getLog();
			
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		return list;
	}





	public LogVO inlogService(String bisbn, String idID, String btitle, Date now) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			int count = dao.inLog(bisbn, idID, btitle, now);		
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}





	public LogVO setReturnBookLogService(String bisbn, String idID, Date date) {
		Connection con = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			Date now = new Date(); //현재시간 반환
			int count = dao.inReLog(bisbn, now, idID, date);		
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}





	public ObservableList<RentalVO> returnBookReflesh(String idID) {
		Connection con = null;
		ObservableList<RentalVO> list = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			list = dao.retrunReflesh(idID);
			
			con.commit();
			con.close();
		} catch (SQLException e) {
		}
		
		return list;
	}





	public LogVO getPointService(String bisbn, String idID) {
		
		Connection con = null;
		LogVO log = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			BookDAO dao = new BookDAO(con);

			log = dao.getBDate(bisbn);
			
			System.out.println(dao.getBDate(bisbn).getRetalDay()+" 빌린 일자");
			System.out.println(dao.getBDate(bisbn).getReturnDay()+" 반납 일자");
			
			long sec = (dao.getBDate(bisbn).getReturnDay().getTime() - dao.getBDate(bisbn).getRetalDay().getTime())/1000;
			
			long rDay = sec / (24*60*60);
				
			System.out.println("총 대여 일자 : " + rDay+"일");
			
			if (rDay <= 7) {
				//포인트 증가
				System.out.println("포인트가 증가합니다");
				dao.upPoint(idID);
			} else if (rDay > 7){
				//포인트 감소
				System.out.println("연체일만큼 포인트가 마이너스 됩니다.");
				dao.downPoint(idID, rDay);
			}
			
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}





	public UserVO getInfoService(String idID) {
		Connection con = null;
		UserVO user = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			user = dao.getUserInfo(idID);
			
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}





	public BookVO getBIService(String bookISBN) {
		Connection con = null;
		BookVO bv = null;
		
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			
			BookDAO dao = new BookDAO(con);
			
			bv = dao.getBookInfo(bookISBN);
			
			
			con.commit();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bv;
	}



	//마이바티스로 회원가입된 유저 값 넣어주는 서비스
	public ObservableList<UserVO> joinUserMB(String id, String pw, String em) {
		
		BookDAO dao = new BookDAO(factory);
		ObservableList<UserVO> list = dao.joinUserMB(id, pw, em);
		return list;
	}
	
	//마이바티스로 로그인하기 및 로그인 체크 서비스
	public Boolean LoginUserCheck(String text, String text2) {
		BookDAO dao = new BookDAO(factory);
		UserVO list = dao.loginUserMB(text, text2);
		Boolean check = false;
		
		
		
		if(text.equals(list.getUser_ID()) && text2.equals(list.getUser_PW())) {
			check = true;
			System.out.println("로그인 성공 !! " + list.getUser_ID() +"님의 접속 환영");
		} else {
			check = false;
			System.out.println("로그인 실패 아이디 비밀번호를 다시 확인해주세요!!");
		}
		
		
		return check;
	}
	
	//마이바티스로 사용자 자기 정보 가져오기
	public ObservableList<UserVO> userInfoMB(String idID) {
		BookDAO dao = new BookDAO(factory);
		ObservableList<UserVO> list = dao.getUserInfoMB(idID);
		return list;
	}
	
	
	//마이바티스로 로그 테이블 가져오는 서비스
	public ObservableList<LogVO> getLogMB() {
		BookDAO dao = new BookDAO(factory);
		ObservableList<LogVO> listMB = dao.getLogMB();
		return listMB;
	}
	
	//마이바티스로 사용자 개인 대여 현황을 볼 수 있는 테이블 가져옴
	public ObservableList<RentalVO> getPersonalRentalInfoMB(String idID) {
		BookDAO dao = new BookDAO(factory);
		ObservableList<RentalVO> listMB = dao.getPRentalBookMB();
		return listMB;
	}
	
	//마이바티스로 
	public ObservableList<BookVO> addBookServiceMB(String text, String text2, String text3, int parseInt, int parseInt2,
			String text4, String text5, String text6, String text7, int parseInt3) {
		
		BookDAO dao = new BookDAO(factory);
		ObservableList<BookVO> listMB = dao.insertBookMB(text, text2, text3, parseInt, parseInt2,
				text4, text5, text6, text7, parseInt3);
		return listMB;
	}



}
