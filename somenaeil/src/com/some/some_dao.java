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
	
	
	// DB에서 유저 세션을 불러와서
	// follow, follower, scrap, like, dm, noti 정보 받아서 사용
	
}
