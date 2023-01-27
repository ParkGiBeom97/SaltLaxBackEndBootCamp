package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {
	
	public static void main(String[] args) {
		
		//특정책을 지움
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			con.setAutoCommit(false);//Transaction이 시작됨
			
			String sql = "DELETE FROM book WHERE btitle LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);		
			pstmt.setString(1, "%여행%");
			
			
			int count = pstmt.executeUpdate();
			//리턴값은 정수값이 옴..
			//영향을 받은 row의 수가 리턴됨
			
			//조회가 따로 없는 결과 처리
			System.out.println("삭제한 row의 갯수 => " + count);
			
			//con.commit(); //트랜잭션을 종료하고 지금까지 실행된 SQL문을 실제로 적용함
			con.rollback(); //트랜잭션을 종료하고 지금까지 실행된 SQL문을 무효화함
			//만약 트랜잭션을 종료하지 않고 connection을 close하면 트랜잭션을 종료하고 지금까지 실행된 SQL문을 실제로 적용함
			
			//사용한 자원 반납
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
