package com.some;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class some_dao {
	private Connection conn;
	
	public some_dao() {
		try {
			conn= DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e) {
			System.out.println("some_dao - DB 커넥션 실패");
		}
	}
	
	
	// DB에서 유저 id를 불러와서
	// sql문에 유저 id_dm 형태로 작성
	// 

}
