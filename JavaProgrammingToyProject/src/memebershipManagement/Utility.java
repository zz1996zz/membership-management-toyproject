package memebershipManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utility {

	static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	static final String USER = "sa";
	static final String PASSWORD = "";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new org.h2.Driver());
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement stat) {
		
		try {
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement stat, ResultSet rs) {
		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
