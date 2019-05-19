package sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * DB 관련 공통 기능 클래스
 */

public class JdbcUtil {
	// MySQL에서 제공하는 드라이버 클래스를 로딩하는 부분
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// MySQL 서버로 연결해주는 부분
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "javaDB", "");
			con.setAutoCommit(false); // DB 작업시 트랜잭션을 적용 할 수있게 처리하는 부분
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	// Connection 객체를 닫아주는 메소드 정의
	public static void close(Connection con) {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// Statement 객체를 닫아주는 메소드
	public  static void close(Statement stmt) {
		try {
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// ResultSet 객체를 닫아주는 메소드 정의
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// 트랜잭션 중에 이루어진 작업을 완성시키는 메소드를 정의한 부분
	public static void commit(Connection con) {
		try {
			con.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 트랜잭션 주엥 이루어진 작업을 취소시키는 메소드를 정의한 부분
	public static void rollback(Connection con) {
		try {
			con.rollback();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}