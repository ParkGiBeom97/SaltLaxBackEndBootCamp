package bookproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bookproject.vo.BookVO;
import bookproject.vo.RentalVO;
import bookproject.vo.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDAO {
	
	Connection con;
	public BookDAO() {
		
	}
	public BookDAO(Connection con) {
		super();
		this.con = con;
	}

	
	//전체 책 보여주는 dao
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

			while(rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("bauthor"),
						rs.getInt("bprice"), rs.getInt("bpage"), rs.getString("bpublisher"));
				list.add(book);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e1) {
		}
		
		return list;
	}
	
	//회원가입
	public int userInsert(String id, String pw, String em) {
		
		String sql = ("INSERT INTO usertbl (user_id, user_pw, user_EM) VALUES (?, ?, ?)");
		
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, em);
			
			pstmt.executeUpdate();
			
			System.out.println("데이터 전송 성공" + "아디 : "+ id+" 비번 : "+pw +" 이메일 : " + em);
			
			pstmt.close();
			
		} catch (SQLException e) {
			
		}
		return 0;
	}
	
	
	//로그인 관련
	public UserVO userLogin(String text, String text2) {
		
		String sql = "SELECT user_id, user_pw FROM usertbl WHERE user_id = ? AND user_pw = ?";
		UserVO user = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, text);
			pstmt.setString(2, text2);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				user = new UserVO(rs.getString("user_ID"), rs.getString("user_PW"));
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	//회원가입dao
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

			while(rs.next()) {
				UserVO user = new UserVO(rs.getString("user_ID"),
						rs.getString("user_PW"),
						rs.getString("user_EM"),
						rs.getInt("user_point"));
				list.add(user);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e1) {
		}
		
		return list;
	}
	
	
	//대출테이블에 대출 현황 넣기
	public int rentalTb(String bisbn, String btitle, String idID) {
		String sql = ("INSERT INTO bookrental(bisbn, btitle, user_ID) VALUES(?, ?, ?)");
		
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);
			pstmt.setString(2, btitle);
			pstmt.setString(3, idID);
			
			pstmt.executeUpdate();
			
			System.out.println("데이터 전송 성공" + "책번호 : "+ bisbn+" 책제목 : "+btitle +" 빌린사람아이디 : " + idID);
			
			pstmt.close();
			
		} catch (SQLException e) {
			
		}
		return 0;
	}
	
	
	//사용자별 대출 현황보기
	public ObservableList<RentalVO> PersnalRentalInfo(String idID) {
		ObservableList<RentalVO> list = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, user_ID, rentalDay ");
		sql.append("FROM bookrental ");
		sql.append("WHERE user_ID = ? ");
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, idID);
			
			ResultSet rs = pstmt.executeQuery();
			
			list = FXCollections.observableArrayList();

			while(rs.next()) {
				RentalVO user = new RentalVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("user_ID"),
						rs.getDate("rentalDay"));
				list.add(user);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e1) {
		}
		
		return list;
	}
	
	//전체 대출 현황 보기
	public ObservableList<RentalVO> SeeRentalBook() {
		ObservableList<RentalVO> list = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, user_ID, rentalDay ");
		sql.append("FROM bookrental ");
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			list = FXCollections.observableArrayList();

			while(rs.next()) {
				RentalVO user = new RentalVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("user_ID"),
						rs.getDate("rentalDay"));
				list.add(user);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e1) {
		}
		
		return list;
	}
	
	
	//책 갯수 -1 해주기 대여 누르면
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
	
	//책 갯수 가져오기
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

			while(rs.next()) {
				book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"),rs.getInt("BookRental"));
				list.add(book);
			}
			
			System.out.println(rs.getInt("BookRental"));

			
		} catch (Exception e1) {
		}
		
		return list;
	}
	
	

	

}
