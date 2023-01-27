package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Test;

public class test2 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/mysql_test_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT td.CATEGORY, td.DEPARTMENT_NAME, SUM(td.CAPACITY)");
			sql.append("FROM tb_department td ");
			sql.append("WHERE td.CATEGORY = '공학' ");
			sql.append("AND td.CAPACITY BETWEEN 20 AND 30 ");
			sql.append("group by td.CATEGORY, td.DEPARTMENT_NAME ");
			sql.append("ORDER BY td.DEPARTMENT_NAME");
			
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<Test> list = new ArrayList<Test>();
			
			
			while(rs.next()) {
				Test test = new Test(rs.getString("category"), rs.getString("department_name"), rs.getInt("SUM(td.CAPACITY)"));        
				list.add(test);
			}
			
			for(Test test: list) {
				System.out.println(test);
			}
			
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
