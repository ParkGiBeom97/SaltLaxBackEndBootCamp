package bookproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bookproject.vo.BookVO;
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
	public int userInsert(String id, String pw) {
		
		String sql = ("INSERT INTO usertbl (user_id, user_pw) VALUES (?, ?)");
		
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			pstmt.executeUpdate();
			
			System.out.println("데이터 전송 성공" + "아디 : "+ id+" 비번 : "+pw);
			
			pstmt.close();
			
		} catch (SQLException e) {
			
		}
		
		
		
		
		return 0;
	}
	
	
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

}
