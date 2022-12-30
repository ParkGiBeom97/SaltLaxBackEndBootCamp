package lecture.jdbc.di.step3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class UserDAO {
	
	
	protected abstract Connection getConnection();
	
	
	public void insert(User user) {
		
		try {
			
			
			Connection con = getConnection();
			
			String sql = "INSERT INTO users VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User select(String string) {
		
		User user = null;
		
		try {
			Connection con = getConnection();
			
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, string);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			user = new User(string, rs.getString("name"), rs.getString("password"));
			
			
			rs.close();
			pstmt.close();
			con.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
