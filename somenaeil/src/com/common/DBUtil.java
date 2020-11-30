package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 자주 쓰는 DB 함수들을 모아놓기
 * @author gagip
 *
 */
public class DBUtil {
	
	/**
	 * 커넥션 연결 메소드
	 * @author gagip
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("member_dao - member DB 커넥션 실패");
		}
		return conn;
	}
	
	/**
	 * 인덱스(num) 증가 메소드
	 * @author gagip
	 * @param table	해당 DB
	 * @param conn Connection
	 * @return
	 * @throws SQLException
	 */
	public static int getNum(String table, Connection conn) throws SQLException {
		int num= 1;
		
		String sql= "select Max(num) as idx from "+table;
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			if(rs.next()) {
				num= rs.getInt("idx")+1;
			}
			return num;
		} catch(SQLException e) {
			System.out.println("DBUtil - num값 증가 실패");
		}
		
		rs.close();
		stmt.close();
		
		return num;
	}
	
	
	public static void close(Connection conn) {
		try {
			if (conn != null) conn.close(); conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close(); pstmt = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null) rs.close(); rs = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
