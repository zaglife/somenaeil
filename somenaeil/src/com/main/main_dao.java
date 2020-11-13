package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main_dao {
	private Connection conn;
	
	public main_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("main_dao - 실패");
		}
	}
	
	public static int get_num(String table, Connection conn) throws SQLException {
		int num= 1;
		
		String sql= "select Max(num) as m from "+table;
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			if(rs.next()) {
				num= rs.getInt("m")+1;
			}
			return num;
		} catch(SQLException e) {
			System.out.println("main_dao - num값 증가 실패");
		}
		
		rs.close();
		stmt.close();
		
		return num;
	}
}
