package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		
		//클레스 이름가지고 찾은 후 로딩해라
		//드라이버 로딩 단계
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading 성공!");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw ="test1234";
			
			//데이터베이스 접속
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			System.out.println("데이터베이스 접속 성공!");
			
			//일반statement사용
//			//statement 생성
//			Statement stmt = con.createStatement();
//			
//			//쿼리를 작성해서 실행시킴
//			String keyword = "자바";
//			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle LIKE '%"+keyword+"%'";
//			//select문을 실행시킴
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			//결과처리
			
			//preparedStatement는 IN parameter를 이용할 수 있음 => ?로 표현함
			//주의해야될 점은 SQL키워드 부분에는 사용할 수 없음
			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle LIKE ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			//실행하기전 ?를 채워야함	
			String keyword = "자바";
			pstmt.setString(1, "%" + keyword + "%");
			
			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next()){ 
				String title = rs.getString("btitle"); 
				int price = rs.getInt("bprice");
				System.out.println("책 제목은 => " + title);
				System.out.println("책 가격은 => " + price);  //컬럼명을 사용해되고 숫자를 사용해도 되지만 컬럼명을 사용하는것이 좋음 
			 }
			 		
			//사용한 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
