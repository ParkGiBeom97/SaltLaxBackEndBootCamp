package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.vo.Book;

public class test1 {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("검색하고 싶은 책 제목을 입력하세요...");
			String keyword = sc.nextLine();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
				String id = "root";
				String pw = "test1234";
				Connection con = DriverManager.getConnection(jdbc_url, id, pw);
				
				String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle LIKE ? ORDER BY bprice DESC";
				
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, "%" + keyword + "%");
				
				ResultSet rs =  pstmt.executeQuery();
				
				System.out.println("검색하신 책 제목의 키워드는 : " + keyword);
				
				ArrayList<Book> list = new ArrayList<Book>();
				
				while(rs.next()){ 
					Book book = new Book(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
					list.add(book);
				 }
				
				for(Book book: list) {
					System.out.println(book);
				}
				
				System.out.println("이상으로 검색 결과를 마칩니다.");
				 		
				//사용한 자원 해제
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
}
