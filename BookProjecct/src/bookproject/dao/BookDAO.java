package bookproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bookproject.vo.BookVO;
import bookproject.vo.LogVO;
import bookproject.vo.RentalVO;
import bookproject.vo.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDAO {

	Connection con;
	public BookDAO(Connection con) {
		super();
		this.con = con;
	}

	public BookDAO() {

	}

	// 마이바티스////////////////
	private SqlSessionFactory factory;

	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}
	// 마이바티스////////////////

	// 전체 책 보여주는 dao
	public ObservableList<BookVO> BookSerch(String text) {

		ObservableList<BookVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice, bpage, bpublisher ");
		sql.append("FROM book ");
		sql.append("WHERE btitle like ? ");
		sql.append("ORDER BY bprice DESC ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + text + "%");

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"),
						rs.getInt("bprice"), rs.getInt("bpage"), rs.getString("bpublisher"));
				list.add(book);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e1) {
		}

		return list;
	}

	// 회원가입
	public int userInsert(String id, String pw, String em) {

		String sql = ("INSERT INTO usertbl (user_id, user_pw, user_EM) VALUES (?, ?, ?)");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, em);

			pstmt.executeUpdate();

			System.out.println("데이터 전송 성공" + "아디 : " + id + " 비번 : " + pw + " 이메일 : " + em);

			pstmt.close();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 로그인 관련
	public UserVO userLogin(String text, String text2) {

		String sql = "SELECT user_id, user_pw FROM usertbl WHERE user_id = ? AND user_pw = ?";
		UserVO user = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, text);
			pstmt.setString(2, text2);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new UserVO(rs.getString("user_ID"), rs.getString("user_PW"));
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	// 회원가입dao
	public ObservableList<UserVO> UserInfo(String idID) {
		ObservableList<UserVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT user_ID, user_PW, user_EM, user_POINT ");
		sql.append("FROM userTBL ");
		sql.append("WHERE user_ID = ? ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, idID);

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				UserVO user = new UserVO(rs.getString("user_ID"), rs.getString("user_PW"), rs.getString("user_EM"),
						rs.getInt("user_point"));
				list.add(user);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e1) {
		}

		return list;
	}

	// 대출테이블에 대출 현황 넣기
	public int rentalTb(String bisbn, String btitle, String idID) {
		String sql = ("INSERT INTO bookrental(bisbn, btitle, user_ID) VALUES(?, ?, ?)");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);
			pstmt.setString(2, btitle);
			pstmt.setString(3, idID);

			pstmt.executeUpdate();

			System.out.println("데이터 전송 성공" + "책번호 : " + bisbn + " 책제목 : " + btitle + " 빌린사람아이디 : " + idID);

			pstmt.close();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 사용자별 대출 현황보기
	public ObservableList<RentalVO> PersnalRentalInfo(String idID) {
		ObservableList<RentalVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, user_ID, rentalDay ");
		sql.append("FROM bookrental ");
		sql.append("WHERE user_ID = ? ");
		sql.append("ORDER BY rentalDAY desc ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, idID);

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				RentalVO user = new RentalVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("user_ID"),
						rs.getDate("rentalDay"));
				list.add(user);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e1) {
		}

		return list;
	}

	// 전체 대출 현황 보기
	public ObservableList<RentalVO> SeeRentalBook() {
		ObservableList<RentalVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, user_ID, rentalDay ");
		sql.append("FROM bookrental ");
		sql.append("ORDER BY rentalDAY desc ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				RentalVO user = new RentalVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("user_ID"),
						rs.getDate("rentalDay"));
				list.add(user);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e1) {
		}

		return list;
	}

	// 책 갯수 -1 해주기 대여 누르면
	public int rentalMinus(String bisbn) {

		String sql = ("UPDATE book SET BookRental = BookRental -1 WHERE bisbn = ? ");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);

			pstmt.executeUpdate();
			con.commit();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 책 갯수 가져오기
	public ObservableList<BookVO> rentalBookCheck(String bisbn) {
		ObservableList<BookVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, BookRental ");
		sql.append("FROM book ");
		sql.append("WHERE bisbn = ? ");

		BookVO book = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, bisbn);

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getInt("BookRental"));
				list.add(book);
			}

			System.out.println(rs.getInt("BookRental"));

		} catch (Exception e1) {
		}

		return list;
	}

	// 개인 대여 도서테이블에서 값 지우기
	public int returnBook(String bisbn, String idID, Date date) {
		String sql = ("DELETE FROM bookrental WHERE bisbn = ? AND user_ID = ? AND rentalDay = ?");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			pstmt.setString(2, idID);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pstmt.setDate(3, sqlDate);

			System.out.println(pstmt);

			pstmt.executeUpdate();

			System.out.println("데이터 삭제 시작!!  " + "책번호 : " + bisbn + " 삭제 성공");

			con.commit();

			pstmt.close();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 반납한 책 book테이블에 재고 올려주기
	public int plusBook(String bisbn) {

		String sql = ("UPDATE book SET bookrental = bookrental + 1 WHERE bisbn = ? ");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);

			pstmt.executeUpdate();

		} catch (SQLException e) {

		}
		return 0;

	}

	// 책테이블에서 책 삭제
	public int deleteBBook(String bisbn) {
		String sql = ("DELETE FROM book WHERE bisbn = ? ");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);

			pstmt.executeUpdate();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 대여테이블에서 책 삭제
	public int deleteRBook(String bisbn) {
		String sql = ("DELETE FROM bookrental WHERE bisbn = ? ");

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);

			pstmt.executeUpdate();

			con.commit();

		} catch (SQLException e) {

		}
		return 0;
	}

	// 책 추가하는 거임
	public int addBook(String text, String text2, String text3, int parseInt, int parseInt2, String text4, String text5,
			String text6, String text7, int parseInt3) {

		String sql = ("INSERT INTO book(bisbn, btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher, Bookrental) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setString(2, text2);
			pstmt.setString(3, text3);
			pstmt.setInt(4, parseInt);
			pstmt.setInt(5, parseInt2);
			pstmt.setString(6, text4);
			pstmt.setString(7, text5);
			pstmt.setString(8, text6);
			pstmt.setString(9, text7);
			pstmt.setInt(10, parseInt3);
			pstmt.executeUpdate();

		} catch (SQLException e) {

		}
		return 0;
	}

	public int updateBook(String text, String text2, String text3, int parseInt, int parseInt2, String text4,
			String text5, String text6, String text7, int parseInt3, String bookISBN) {

		String sql = ("UPDATE book SET bisbn = ?, btitle = ?, bdate = ?, bpage = ?, bprice = ?, bauthor = ?, btranslator = ?, bsupplement = ?, bpublisher= ?, Bookrental = ? WHERE bisbn = ?");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setString(2, text2);
			pstmt.setString(3, text3);
			pstmt.setInt(4, parseInt);
			pstmt.setInt(5, parseInt2);
			pstmt.setString(6, text4);
			pstmt.setString(7, text5);
			pstmt.setString(8, text6);
			pstmt.setString(9, text7);
			pstmt.setInt(10, parseInt3);
			pstmt.setString(11, bookISBN);
			pstmt.executeUpdate();

			System.out.println(pstmt);

		} catch (SQLException e) {

		}
		return 0;
	}

	public int userUpdate(String string, String string2, String string3, String idID) {
		String sql = ("UPDATE usertbl SET user_id = ?, user_pw =?,user_em = ? WHERE user_ID = ?");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, string);
			pstmt.setString(2, string2);
			pstmt.setString(3, string3);
			pstmt.setString(4, idID);

			pstmt.executeUpdate();

			System.out.println(pstmt);

		} catch (SQLException e) {

		}
		return 0;
	}

	// 로그 기록 가져오기
	public ObservableList<LogVO> getLog() {

		String sql = ("SELECT bisbn, user_ID, btitle, rentalDay, returnDay FROM logtbl");
		ObservableList<LogVO> list = null;
		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);

			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();

			while (rs.next()) {
				LogVO log = new LogVO(rs.getString("bisbn"), rs.getString("user_ID"), rs.getString("btitle"),
						rs.getDate("rentalDay"), rs.getDate("returnDay"));
				list.add(log);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return list;
	}

	public int inLog(String bisbn, String idID, String btitle, Date now) {
		String sql = ("INSERT INTO logtbl (bisbn, user_ID, btitle, rentalDay) values (?, ?, ?, ?);");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			pstmt.setString(2, idID);
			pstmt.setString(3, btitle);

			java.sql.Date sqlDate = new java.sql.Date(now.getTime());
			pstmt.setDate(4, sqlDate);

			pstmt.executeUpdate();

			System.out.println(pstmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 반납하면 로그 기록에 반납 시간 업데이트
	public int inReLog(String bisbn, Date now, String idID, Date date) {
		String sql = ("UPDATE logtbl SET returnDay = ? WHERE bisbn = ? AND user_id = ? AND  rentalDay = ?");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			java.sql.Date sqlDate = new java.sql.Date(now.getTime());
			pstmt.setDate(1, sqlDate);
			pstmt.setString(2, bisbn);
			pstmt.setString(3, idID);
			java.sql.Date sqlRDate = new java.sql.Date(date.getTime());
			pstmt.setDate(4, sqlRDate);

			pstmt.execute();

			System.out.println(pstmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public ObservableList<RentalVO> retrunReflesh(String idID) {
		ObservableList<RentalVO> list = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, user_ID, rentalDay ");
		sql.append("FROM bookrental ");
		sql.append("WHERE user_ID = ? ");
		sql.append("ORDER BY rentalDAY desc ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, idID);

			ResultSet rs = pstmt.executeQuery();

			list = FXCollections.observableArrayList();

			while (rs.next()) {
				RentalVO user = new RentalVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("user_ID"),
						rs.getDate("rentalDay"));
				list.add(user);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e1) {
		}

		return list;
	}

	// 대여날짜와 반납 날짜를 받아오는 dao
	public LogVO getBDate(String bisbn) {

		String sql = "SELECT rentalDay, returnDay FROM logtbl WHERE bisbn = ? ";
		LogVO day = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				day = new LogVO(rs.getDate("rentalDay"), rs.getDate("returnDay"));
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return day;
	}

	// 사용자의 포인트를 올려주는 dao
	public void upPoint(String idID) {

		String sql = ("UPDATE usertbl SET user_POINT = user_POINT + 1 WHERE user_ID = ?");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idID);

			pstmt.executeUpdate();

			System.out.println(pstmt);

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void downPoint(String idID, long rDay) {
		String sql = ("UPDATE usertbl SET user_POINT = user_POINT - (1*?) WHERE user_ID = ?");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, rDay);
			pstmt.setString(2, idID);

			pstmt.executeUpdate();

			System.out.println(pstmt);

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public UserVO getUserInfo(String idID) {
		String sql = "SELECT user_ID, user_pw, user_em, user_POINT FROM usertbl WHERE user_id = ? ";
		UserVO user = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, idID);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new UserVO(rs.getString("user_ID"), rs.getString("user_pw"), rs.getString("user_em"),
						rs.getInt("user_POINT"));
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public BookVO getBookInfo(String bookISBN) {

		BookVO bv = new BookVO();
		String sql = ("SELECT bisbn, btitle, bdate, bpage, bprice, bauthor, btranslator, bsupplement, bpublisher, BookRental "
				+ "FROM book WHERE bisbn = ? ");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookISBN);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bv = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bdate"),
						rs.getInt("bpage"), rs.getInt("bprice"), rs.getString("bauthor"), rs.getString("btranslator"),
						rs.getString("bsupplement"), rs.getString("bpublisher"), rs.getInt("BookRental"));
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bv;
	}

	// 테스트 삭제 예정
	public int updateByISBN(BookVO book) {
		int result = 0;
		SqlSession session = factory.openSession();

		// 업데이트 구문은 update를 사용한다
		try {
			result = session.update("mybatiesBook.update", book);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	//////////// 마이바티스 책 가져오는 부분////////
	public ObservableList<BookVO> selectAllBook(String text) {
		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();

		ObservableList<BookVO> listO = null;
		listO = FXCollections.observableArrayList();

		try {

			list = session.selectList("mybatiesBook.selectAllBook", text);
			for (HashMap<String, Object> map : list) {
				BookVO book = new BookVO((String) map.get("bisbn"), (String) map.get("btitle"),
						(String) map.get("bauthor"), (int) map.get("bprice"), (int) map.get("bpage"),
						(String) map.get("bpublisher"));

				listO.add(book);
			}

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return listO;
	}

	/////// 마이바티스 회원가입 시키기//////
	public ObservableList<UserVO> joinUserMB(String id, String pw, String em) {

		SqlSession session = factory.openSession();

		ObservableList<UserVO> listO = null;
		listO = FXCollections.observableArrayList();

		UserVO user = new UserVO();
		user.setUser_ID(id);
		user.setUser_PW(pw);
		user.setUser_EM(em);

		System.out.println(user.getUser_ID() + "아이디");
		session.insert("mybatiesBook.insertUser", user);
		session.commit();
		return listO;
	}

	// 마이바티스 로그인 관련 dao
	public UserVO loginUserMB(String text, String text2) {

		SqlSession session = factory.openSession();
		UserVO listO = null;
		List<HashMap<String, Object>> list = null;

		UserVO user = new UserVO();
		user.setUser_ID(text);
		user.setUser_PW(text2);

		try {
			list = session.selectList("mybatiesBook.selectIdPw", user);
			for (HashMap<String, Object> map : list) {
				System.out.println(map.get("user_ID"));
				listO = new UserVO((String) map.get("user_ID"), (String) map.get("user_PW"));
			}
		} catch (Exception e) {
			System.out.println("로그인 시도 실패");
		} finally {
			session.close();
		}
		return listO;
	}

	// 마이바티스를 가지고 회원정보 가져오는 dao
	public ObservableList<UserVO> getUserInfoMB(String idID) {
		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();

		ObservableList<UserVO> listO = null;
		listO = FXCollections.observableArrayList();

		try {
			list = session.selectList("mybatiesBook.getUserInfoMB", idID);
			for (HashMap<String, Object> map : list) {
				UserVO user = new UserVO((String) map.get("user_ID"), (String) map.get("user_PW"),
						(String) map.get("user_EM"), (int) map.get("user_point"));
				listO.add(user);
			}

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return listO;
	}

	// 마이바티스 책 대여 로그 가져오는 dao
	public ObservableList<LogVO> getLogMB() {
		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();
		ObservableList<LogVO> listMB = null;
		listMB = FXCollections.observableArrayList();
		try {
			list = session.selectList("mybatiesBook.getLogMB");
			for (HashMap<String, Object> map : list) {
				LogVO logMB = new LogVO((String) map.get("bisbn"), (String) map.get("user_ID"),
						(String) map.get("btitle"), (Date) map.get("rentalDay"), (Date) map.get("returnDay"));
				listMB.add(logMB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listMB;
	}

	// 마이바티스를 통한 사용자 개인 대여 현황 테이블 가져오기
	public ObservableList<RentalVO> getPRentalBookMB() {
		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();
		ObservableList<RentalVO> listMB = null;
		listMB = FXCollections.observableArrayList();

		try {
			list = session.selectList("mybatiesBook.getPersonalRentalNow");
			for (HashMap<String, Object> map : list) {
				RentalVO rentalP = new RentalVO((String) map.get("bisbn"), (String) map.get("btitle"),
						(String) map.get("user_ID"), (Date) map.get("rentalDay"));
				listMB.add(rentalP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listMB;
	}

	// 마이바티스로 책 삽입하는 dao
	public ObservableList<BookVO> insertBookMB(String text, String text2, String text3, int parseInt, int parseInt2,
			String text4, String text5, String text6, String text7, int parseInt3) {

		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession();
		ObservableList<BookVO> listMB = null;
		listMB = FXCollections.observableArrayList();

		BookVO book = new BookVO();
		book.setBisbn(text);
		book.setBtitle(text2);
		book.setBdate(text3);
		book.setBpage(parseInt);
		book.setBprice(parseInt2);
		book.setBauthor(text4);
		book.setBtranslator(text5);
		book.setBsupplement(text6);
		book.setBpublisher(text7);
		book.setBookRental(parseInt3);

		try {
			session.insert("mybatiesBook.insertBook", book);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return listMB;
	}

	// 마이바티스로 책 수정하는 dao
	public ObservableList<BookVO> updateBookMB(String text, String text2, String text3, int parseInt, int parseInt2,
			String text4, String text5, String text6, String text7, int parseInt3, String bookISBN) {

		SqlSession session = factory.openSession();
		ObservableList<BookVO> listMB = null;
		listMB = FXCollections.observableArrayList();

		BookVO book = new BookVO();
		book.setBisbn(text);
		book.setBtitle(text2);
		book.setBdate(text3);
		book.setBpage(parseInt);
		book.setBprice(parseInt2);
		book.setBauthor(text4);
		book.setBtranslator(text5);
		book.setBsupplement(text6);
		book.setBpublisher(text7);
		book.setBookRental(parseInt3);

		try {
			session.insert("mybatiesBook.updateBook", book);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return listMB;
	}

	// 마이바티스로 삭제하는 책
	public int deleteBBookMB(String bookISBN, String searchKeyword) {

		int result = 0;
		SqlSession session = factory.openSession();

		try {
			session.delete("mybatiesBook.deleteBook", bookISBN);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	// 마이바티스로 삭제하는 책
	public int deleteRBookMB(String bookISBN) {

		int result = 0;
		SqlSession session = factory.openSession();

		try {
			session.delete("mybatiesBook.deleteRBook", bookISBN);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	// 마이바티스로 유저정보 수정
	public int updateUserMB(String text, String text2, String text3, String idID) {
		int result = 0;
		SqlSession session = factory.openSession();

		UserVO user = new UserVO();

		user.setUser_ID(idID);
		user.setUser_PW(text2);
		user.setUser_EM(text3);

		try {
			session.update("mybatiesBook.updateUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	// 마이바티스로 책 정보 가져오기
	public BookVO getBookInfoMB(String bookISBN) {
		SqlSession session = factory.openSession();
		BookVO bookMB = null;

		try {
			bookMB = session.selectOne("mybatiesBook.selectBookInfo", bookISBN);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bookMB;
	}

	// 마이바티스로 전체 대여 현황 가져오기
	public ObservableList<RentalVO> getRBookDAO() {
		SqlSession session = factory.openSession();
		ObservableList<RentalVO> listMB = null;
		listMB = FXCollections.observableArrayList();
		List<HashMap<String, Object>> list = null;

		try {
			list = session.selectList("mybatiesBook.getRAllBook");
			for (HashMap<String, Object> map : list) {
				RentalVO rent = new RentalVO((String)map.get("bisbn"), (String)map.get("btitle"),
								(String)map.get("user_ID"), (Date)map.get("rentalDay"));
				listMB.add(rent);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return listMB;
	}
	
	//마이바티스로 원래 유저 정보 받아오기
	public UserVO getUserInfoMBE(String idID) {
		SqlSession session = factory.openSession();
		UserVO user = null;
		
		try {
			user = session.selectOne("mybatiesBook.getUserE", idID);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return user;
	}

}
